package com.tpirates.api.dto;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import lombok.Data;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class BusinessTimeDTO {
    String day;
    LocalTime open;
    LocalTime close;

    public BusinessTimeDAO toEntity(Long id) {
        return BusinessTimeDAO.builder()
                .id(id)
                .day(weekDay())
                .open(this.open)
                .close(this.close)
                .build();
    }

    private Long weekDay() {
        int n = 8;
        switch (this.day) {
            case "Monday":
                n -= 7;
                break;
            case "Tuesday":
                n -= 6;
                break;
            case "Wednesday":
                n -= 5;
                break;
            case "Thursday":
                n -= 4;
                break;
            case "Friday":
                n -= 3;
                break;
            case "Saturday":
                n -= 2;
                break;
            case "Sunday":
                n -= 1;
                break;
        }

        return new Long(n);
    }
}
