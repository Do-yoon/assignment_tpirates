package com.tpirates.api.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalTime;

@Data
public class BusinessTimeDTO {
    String day;
    LocalTime open;
    LocalTime close;
}
