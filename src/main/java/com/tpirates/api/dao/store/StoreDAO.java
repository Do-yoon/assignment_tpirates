package com.tpirates.api.dao.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class StoreDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length=20, nullable = false)
    private String name;

    @Column(length=20, nullable = false)
    private String owner;

    @Column(length=500, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Builder
    public StoreDAO(String name, String owner, String description, int level, String address, String phone) {
        super();
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.level = level;
        this.address = address;
        this.phone = phone;
    }
}
