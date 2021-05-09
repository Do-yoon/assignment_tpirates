package com.tpirates.api.repository;

import com.tpirates.api.dao.store.HolidayDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HolidayRepository extends JpaRepository<HolidayDAO, Long> {
    @Query("SELECT h FROM HolidayDAO h WHERE h.id=:id ORDER BY h.holiday")
    List<HolidayDAO> findByStoreId(@Param("id") Long id);
}
