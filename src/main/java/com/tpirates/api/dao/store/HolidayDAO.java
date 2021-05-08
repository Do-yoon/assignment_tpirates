package com.tpirates.api.dao.store;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class HolidayDAO {
    @Id
    Long id;

    @Column(nullable = false)
    LocalDateTime holidays;

    public HolidayDAO(String holidays) {
        this.id = id;
        this.holidays = parse(holidays);
    }

    // TODO: parsing Holiday Data
    private LocalDateTime parse(String holidays) {
        return null;
    }
}
