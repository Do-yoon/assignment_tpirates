package com.tpirates.api.repository;

import com.tpirates.api.dao.store.HolidayDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HolidayRepository extends JpaRepository<HolidayDAO, Long> {

}
