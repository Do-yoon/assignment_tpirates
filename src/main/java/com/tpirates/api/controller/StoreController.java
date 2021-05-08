package com.tpirates.api.controller;

import com.tpirates.api.dao.store.StoreDAO;
import com.tpirates.api.dao.store.TestDAO;
import com.tpirates.api.dto.StoreListDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v0/store")
public class StoreController {

    @GetMapping("/storeList")
    public List<?> storeList() {
        List<TestDAO> storeList = new ArrayList<>();

        return storeList;
    }

    @PostMapping("/addStore")
    boolean addStore(@RequestParam String name, @RequestParam String owner, @RequestParam String description, @RequestParam int level, @RequestParam String address, @RequestParam String phone, @RequestParam Date[] businessTimes) {
        return true;
    }
}
