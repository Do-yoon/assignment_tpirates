package com.tpirates.api.repository;

import com.tpirates.api.dao.store.BusinessTimeDAO;
import com.tpirates.api.dto.BusinessTimeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessTimeRepository extends JpaRepository<BusinessTimeDAO, Long> {

    @Query("SELECT sb from BusinessTimeDAO sb order by sb.day")
    List<BusinessTimeDTO> findById();
}
