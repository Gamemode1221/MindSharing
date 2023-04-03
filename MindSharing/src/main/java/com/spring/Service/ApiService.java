package com.spring.Service;

import com.spring.entity.ApiTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    private List<ApiTest> test = new ArrayList<>();

    public List<ApiTest> getTest() {
        return test;
    }

    public void addTest(ApiTest apiTest) {
        test.add(apiTest);
    }
}
