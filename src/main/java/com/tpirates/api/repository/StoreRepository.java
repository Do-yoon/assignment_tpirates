package com.tpirates.api.repository;

import com.tpirates.api.dao.store.StoreDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<StoreDAO, Long> {

    @Query("SELECT s from StoreDAO s order by s.level")
    List<StoreDAO> findAll();

}
