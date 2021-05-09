package com.tpirates.api.dto;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dao.store.HolidayDAO;
import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

// 점포명, 점포 설명, 영업상태(영업중/영업종료/휴무) 정보를 등급(level) 오름차순으로 조회
@Getter
public class StoreListDTO {

    private String name;
    private String description;
    private Long level;
    private String businessStatus;

    public StoreListDTO(StoreDAO entity, List<HolidayDAO> holidays, List<BusinessTimeDAO> businessTimes) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.level = entity.getLevel();
        this.businessStatus = getStatus(holidays, businessTimes);
    }

    private String getStatus(List<HolidayDAO> holidays, List<BusinessTimeDAO> businessTimes) {
        LocalDate todayDate = LocalDate.now();
        LocalTime todayTime = LocalTime.now();
        DayOfWeek day = todayDate.getDayOfWeek();

        // check whether holiday or not
        for (HolidayDAO holiday: holidays) {
            if (day == holiday.getHoliday().getDayOfWeek())
                return "HOLIDAY";
        }

        int dayValue = day.getValue();

        // check whether open or not
        for (BusinessTimeDAO businessTime: businessTimes) {
            if (dayValue == businessTime.getDay()
                    && todayTime.isAfter(businessTime.getOpen())
                    && todayTime.isBefore(businessTime.getClose())) {
                return "OPEN";
            }
        }

        return "CLOSE";
    }
}
