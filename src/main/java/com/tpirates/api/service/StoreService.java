package com.tpirates.api.service;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dao.store.HolidayDAO;
import com.tpirates.api.dao.store.StoreDAO;
import com.tpirates.api.dto.StoreDetailDTO;
import com.tpirates.api.dto.StoreListDTO;
import com.tpirates.api.repository.BusinessTimeRepository;
import com.tpirates.api.repository.HolidayRepository;
import com.tpirates.api.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final BusinessTimeRepository businessTimeRepository;
    private final HolidayRepository holidayRepository;

    @Transactional
    public Long addStore(StoreDAO store) {
        System.out.println("StoreService.addStore()");
        return storeRepository.save(store).getId();
    }

    @Transactional
    public Long regStoreHoliday(Long id, String holidays) {
        System.out.println("StoreService.regStoreHoliday()");
        HolidayDAO holidayDAO = new HolidayDAO(holidays);
        return holidayRepository.save(holidayDAO).getId();
    }

    // C. 점포 목록 조회 API
    @Transactional(readOnly = true)
    public List<StoreListDTO> findAll() {
        System.out.println("StoreService.findAll()");
        List<StoreDAO> list = storeRepository.findAll();
        return list.stream().map(StoreListDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StoreDetailDTO findById(Long id) {
        // TODO: setting businessTimeEntity
        StoreDAO storeEntity = storeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 점포가 없습니다. id=" + id));
        //BusinessTimeDAO storeBusinessTimeEntity = businessTimeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 점포가 없습니다. id=" + id));
        StoreDetailDTO storeDetailDTO = new StoreDetailDTO(storeEntity, null);

        System.out.println("StoreService.findById()");
        return storeDetailDTO;
    }

    @Transactional
    public void deleteStore(Long id) {
        System.out.println("StoreService.deleteStore()");
        StoreDAO posts = storeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 점포가 없습니다. id=" + id));

        storeRepository.delete(posts);
    }

}
