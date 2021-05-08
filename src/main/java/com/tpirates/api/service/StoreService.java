package com.tpirates.api.service;

import com.tpirates.api.dao.store.StoreDAO;
import com.tpirates.api.dao.store.TestDAO;
import com.tpirates.api.dto.StoreDetailDTO;
import com.tpirates.api.dto.StoreListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {

    @Transactional
    public Long addStore(String name, String owner, String description, Long level, String address, String phone, Date[] businessTimes) {
        System.out.println("StoreService.addStore()");
        return new Long(0);
    }

    @Transactional
    public Long regStoreHoliday(Long id, Date[] holidays) {
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
        // StoreDAO entity = null;

        System.out.println("StoreService.findById()");
        return null;
    }

    @Transactional
    public void deleteStore(Long id) {
        System.out.println("StoreService.deleteStore()");
    }

}
