package com.tpirates.api.dao.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class BusinessTimeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long key;

    @Column(nullable = false)
    Long id;

    @Column(length = 10, nullable = false)
    Long day;

    @Column(nullable = false)
    LocalTime open;

    @Column(nullable = false)
    LocalTime close;

    @Builder
    public BusinessTimeDAO(Long id, Long day, LocalTime open, LocalTime close) {
        if (open.isAfter(close)) {
            try {
            Exception e = new IllegalArgumentException("오픈 시간은 영업 종료 시간보다 빨라야 합니다.");
            throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.id = id;
        this.day = day;
        this.open = open;
        this.close = close;
    }

    public void setId(Long id) {
        this.id = id;
    }

}