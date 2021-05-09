package com.tpirates.api.dao.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class HolidayDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long key;

    Long id;

    @Column(length = 10, nullable = false)
    LocalDate holiday;

    @Builder
    public HolidayDAO(Long id, LocalDate holiday) {
        this.id = id;
        this.holiday = holiday;
    }
}
