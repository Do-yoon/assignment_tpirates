package com.tpirates.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class BusinessDaysDTO {
    private String day;
    private LocalTime open;
    private LocalTime close;
    private String status;

    @Builder
    public BusinessDaysDTO(Long day, LocalTime open, LocalTime close, String status) {
        this.day = weekDay(day);
        this.open = open;
        this.close = close;
        this.status = status;
    }

    private String weekDay(Long n) {
        String week = "";
        switch (n.intValue()) {
            case 1:
                week = "Monday";
                break;
            case 2:
                week = "Tuesday";
                break;
            case 3:
                week = "Wednesday";
                break;
            case 4:
                week = "Thursday";
                break;
            case 5:
                week = "Friday";
                break;
            case 6:
                week = "Saturday";
                break;
            case 7:
                week = "Sunday";
                break;
        }

        return week;
    }
}
