package com.tpirates.api.dto;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import lombok.Data;
import lombok.Getter;

import java.time.LocalTime;

@Data
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
        int n = 7;
        switch (this.day) {
            case "Sunday":
                n -= 7;
            case "Monday":
                n -= 6;
            case "Tuesday":
                n -= 5;
            case "Wednesday":
                n -= 4;
            case "Thursday":
                n -= 3;
            case "Friday":
                n -= 2;
            case "Saturday":
                n -= 1;
        }

        return new Long(n);
    }
}
