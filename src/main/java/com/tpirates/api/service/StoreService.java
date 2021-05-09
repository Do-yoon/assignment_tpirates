package com.tpirates.api.service;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dao.store.HolidayDAO;
import com.tpirates.api.dao.store.StoreDAO;
import com.tpirates.api.dto.*;
import com.tpirates.api.repository.BusinessTimeRepository;
import com.tpirates.api.repository.HolidayRepository;
import com.tpirates.api.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final BusinessTimeRepository businessTimeRepository;
    private final HolidayRepository holidayRepository;

    @Transactional
    public Long addStore(StoreRegDTO storeRegDTO) {
        System.out.println("StoreService.addStore()");

        // for store table
        Long id = storeRepository.save(storeRegDTO.toEntity()).getId();
        // for businessTime table
        for (BusinessTimeDTO businessTime : storeRegDTO.getBusinessTimes()) {
            businessTimeRepository.save(businessTime.toEntity(id));
        }

        return id;
    }

    @Transactional
    public Long regStoreHoliday(Long id, HolidayRegDTO holidays) {
        System.out.println("StoreService.regStoreHoliday()");

        // for holiday table
        for (LocalDate holiday : holidays.getHolidays()) {
            HolidayDAO entity = HolidayDAO.builder()
                    .id(id)
                    .holiday(holiday)
                    .build();
            holidayRepository.save(entity);
        }
        return id;
    }

    // C. 점포 목록 조회 API
    @Transactional(readOnly = true)
    public List<StoreListDTO> findAll() {
        System.out.println("StoreService.findAll()");
        List<StoreDAO> storeEntity = storeRepository.findAll();

        List<StoreListDTO> response = new ArrayList<>();
        for (StoreDAO store : storeEntity) {

            response.add(
                    new StoreListDTO(store,
                            holidayRepository.findByStoreId(store.getId()),
                            businessTimeRepository.findByStoreId(store.getId())
                    )
            );
        }
        return response;
    }

    @Transactional(readOnly = true)
    public StoreDetailDTO findById(Long id) {
        // TODO: setting businessTimeEntity
        StoreDAO storeEntity = storeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 점포가 없습니다. id=" + id));
        List<BusinessTimeDAO> businessTimeEntity = businessTimeRepository.findByStoreId(id);
        StoreDetailDTO storeDetailDTO = new StoreDetailDTO(storeEntity, businessTimeEntity);

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
