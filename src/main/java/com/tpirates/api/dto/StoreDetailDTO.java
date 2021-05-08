package com.tpirates.api.dto;

import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;

import java.time.LocalDateTime;

//점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, 조회 일자 기준 영업시간 3일치)

@Getter
public class StoreDetailDTO {
    private int id;
    private String name;
    private String description;
    private int level;
    private String address;
    private LocalDateTime[] businessDays;

    public StoreDetailDTO(StoreDAO entity) {

        //this.businessDays = entity.getOpenTimeList();
    }
}
