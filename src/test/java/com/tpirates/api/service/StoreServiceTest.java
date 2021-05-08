package com.tpirates.api.service;

import com.tpirates.api.dto.StoreDetailDTO;
import com.tpirates.api.dto.StoreListDTO;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceTest {

    @Transactional
    public Long addStore(String name, String owner, String description,
                         Long level, String address, String phone,
                         String businessTimes) {
        System.out.println("StoreService.addStore()");
        return new Long(0);
    }

    @Transactional
    public Long regStoreHoliday(Long id, String holidays) {
        System.out.println("StoreService.regStoreHoliday()");
        return new Long(0);
    }

    // C. 점포 목록 조회 API
    @Transactional(readOnly = true)
    public List<StoreListDTO> findAll() {
        List<StoreListDTO> storeList = new ArrayList<>();
        System.out.println("StoreService.findAll()");
        return storeList;
    }

    // D. 점포 상세 조회 정보 API
    @Transactional(readOnly = true)
    public StoreDetailDTO findById(Long id) {
        // StoreDetailDTO storeDetailDTO = StoreDetailDTO.builder().build();

        System.out.println("StoreService.findById()");
        return null;
    }

    @Transactional
    public void deleteStore(Long id) {
        System.out.println("StoreService.deleteStore()");
    }

}
