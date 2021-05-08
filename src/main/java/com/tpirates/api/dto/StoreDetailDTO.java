package com.tpirates.api.dto;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, 조회 일자 기준 영업시간 3일치)

@Getter
public class StoreDetailDTO {
    private Long id;
    private String name;
    private String description;
    private Long level;
    private String address;
    private List<BusinessTimeDAO> businessDays;

    public StoreDetailDTO(StoreDAO storeEntity, BusinessTimeDAO businessTimeDAO) {
        this.id = storeEntity.getId();
        this.name = storeEntity.getName();
        this.description = storeEntity.getDescription();
        this.level = storeEntity.getLevel();
        this.address = storeEntity.getAddress();
        this.businessDays = getNear3BusinessDays();
    }

    // TODO: logic
    private List<BusinessTimeDAO> getNear3BusinessDays() {
        return new ArrayList<BusinessTimeDAO>();
    }

}
