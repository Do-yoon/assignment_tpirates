package com.tpirates.api.dto;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dao.store.HolidayDAO;
import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, 조회 일자 기준 영업시간 3일치)

@Getter
public class StoreDetailDTO {
    private Long id;
    private String name;
    private String description;
    private Long level;
    private String address;
    private List<BusinessDaysDTO> businessDays;

    public StoreDetailDTO(StoreDAO storeEntity, List<BusinessTimeDAO> businessTimes, List<HolidayDAO> holidays) {
        this.id = storeEntity.getId();
        this.name = storeEntity.getName();
        this.description = storeEntity.getDescription();
        this.level = storeEntity.getLevel();
        this.address = storeEntity.getAddress();
        this.businessDays = getNear3BusinessDays(businessTimes, holidays);
    }

    private List<BusinessDaysDTO> getNear3BusinessDays(List<BusinessTimeDAO> businessTimes, List<HolidayDAO> holidays) {
        List<BusinessDaysDTO> businessDays = new ArrayList<>();
        LocalDate todayDate = LocalDate.now();
        int len = businessTimes.size();
        int idx = -1;
        int cnt = 0;

        // 영업일 정보가 없으면 빈 리스트 반환
        if (len <= 0) {
            return businessDays;
        }

        for (int i = 0; i < len; i++) {
            if (businessTimes.get(i).getDay() < todayDate.getDayOfWeek().getValue()) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            idx = len - 1;
        }

        String status = "OPEN";
        //영업일 검색하여 넣기
        while (true) {
            if (idx < 0) {
                idx = len - 1;
            }
            if (cnt >= 3) {
                break;
            }
            status = "OPEN";
            if (checkHoliday(holidays, new Long(todayDate.getDayOfWeek().getValue())).equals("HOLIDAY")) {
                status = "HOLIDAY";
            }
            todayDate = todayDate.minusDays(Math.abs(todayDate.getDayOfWeek().getValue() - businessTimes.get(idx).getDay()));
            businessDays.add(BusinessDaysDTO.builder()
                    .day(new Long(todayDate.getDayOfWeek().getValue()))
                    .open(businessTimes.get(idx).getOpen())
                    .close(businessTimes.get(idx).getClose())
                    .status(getStatus(holidays, businessTimes, todayDate))
                    .build()
            );
            cnt++;
            idx--;
        }


        return businessDays;

    }

    private String getStatus(List<HolidayDAO> holidays, List<BusinessTimeDAO> businessTimes, LocalDate givenDate) {
        DayOfWeek day = givenDate.getDayOfWeek();

        // check whether holiday or not
        if (checkHoliday(holidays, new Long(day.getValue())).equals("HOLIDAY")) {
            return "HOLIDAY";
        }

        int dayValue = givenDate.getDayOfWeek().getValue();

        // check whether open or not
        for (BusinessTimeDAO businessTime: businessTimes) {
            System.out.println(dayValue);
            System.out.println(businessTime.getDay());
            if (dayValue == businessTime.getDay()) {
                return "OPEN";
            }
        }

        return "CLOSE";
    }

    private String checkHoliday(List<HolidayDAO> holidays, Long day) {
        for (HolidayDAO holiday: holidays) {
            if (day == holiday.getHoliday().getDayOfWeek().getValue())
                return "HOLIDAY";
        }
        return "";
    }

}
