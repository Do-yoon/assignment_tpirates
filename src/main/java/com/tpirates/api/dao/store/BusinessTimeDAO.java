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
    private Long key;

    @Column(nullable = false)
    private Long id;

    @Column(length = 10, nullable = false)
    private Long day;

    @Column(nullable = false)
    private LocalTime open;

    @Column(nullable = false)
    private LocalTime close;

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