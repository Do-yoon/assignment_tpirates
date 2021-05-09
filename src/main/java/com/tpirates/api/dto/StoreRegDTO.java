package com.tpirates.api.dto;

import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class StoreRegDTO {
    private Long id;
    private String name;
    private String owner;
    private String description;
    private Long level;
    private String address;
    private String phone;
    private List<BusinessTimeDTO> businessTimes;

    public StoreDAO toEntity() {
        return StoreDAO.builder()
                .name(this.name)
                .owner(this.owner)
                .description(this.description)
                .level(this.level)
                .address(this.address)
                .phone(this.phone)
                .build();
    }
}
