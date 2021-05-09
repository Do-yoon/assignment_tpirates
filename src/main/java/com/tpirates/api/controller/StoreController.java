package com.tpirates.api.controller;

import com.tpirates.api.dao.store.StoreDAO;
import com.tpirates.api.dto.HolidayRegDTO;
import com.tpirates.api.dto.StoreDetailDTO;
import com.tpirates.api.dto.StoreListDTO;
import com.tpirates.api.dto.StoreRegDTO;
import com.tpirates.api.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v0/store")
public class StoreController {

    private final StoreService storeService;

    // A. 점포 추가 API
    @PostMapping("/addStore")
    public Long addStore(@RequestBody StoreRegDTO storeRegDTO) {
        return storeService.addStore(storeRegDTO);
    }

    // B. 점포 휴무일 등록 API
    @PostMapping("/regStoreHoliday/{id}")
    public Long regStoreHoliday(@PathVariable Long id, @RequestBody HolidayRegDTO holidays) {
        return storeService.regStoreHoliday(id, holidays);
    }

    // C. 점포 목록 조회 API
    @GetMapping("/storeList")
    public List<StoreListDTO> storeList() {
        return storeService.findAll();
    }

    // D. 점포 상세 정보 조회 API
    @GetMapping("/storeDetails")
    public StoreDetailDTO getStoreDetail(@RequestParam Long id) {
        return storeService.findById(id);
    }

    // E. 점포 삭제 API
    @DeleteMapping("/deleteStore")
    public Long deleteStore(@RequestParam Long id) {
        storeService.deleteStore(id);
        return id;
    }

}
