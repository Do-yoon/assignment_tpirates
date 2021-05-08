package com.tpirates.api.dto;

import com.tpirates.api.dao.store.StoreDAO;
import lombok.Getter;

// 점포명, 점포 설명, 영업상태(영업중/영업종료/휴무) 정보를 등급(level) 오름차순으로 조회
@Getter
public class StoreListDTO {

    private String name;
    private String description;
    private int level;
    private String businessStatus;

    public StoreListDTO(StoreDAO entity) {
        //this.openTime = entity.getOpenTimeList();
    }

}
