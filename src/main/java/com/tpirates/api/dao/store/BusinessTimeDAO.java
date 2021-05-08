package com.tpirates.api.dao.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class BusinessTimeDAO {
    @Id
    int id;
    int day;
    LocalTime open;
    LocalTime close;

    @Builder
    public BusinessTimeDAO(int id, int day, LocalTime open, LocalTime close) {
        this.id = id;
        this.day = day;
        this.open = open;
        this.close = close;
    }

    // TODO: parsing businessTimes
}