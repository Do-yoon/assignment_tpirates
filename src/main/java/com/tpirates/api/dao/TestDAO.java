package com.tpirates.api.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestDAO {
    int a;
    String b;

    @Builder
    public TestDAO(int a, String b) {
        this.a = a;
        this.b = b;
    }
}
