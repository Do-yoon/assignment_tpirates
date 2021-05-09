package com.tpirates.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tpirates.api.dao.store.HolidayDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class HolidayRegDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private List<LocalDate> holidays;
}
