package com.bondif.microservices.tp1.companyservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class CompanyRestService {

    @Value("${xParam}")
    private int xParam;

    @Value("${yParam}")
    private int yParam;

    @Value("${me}")
    private String me;

    @GetMapping(value = "/config")
    public Map myConfig() {
        Map<String, String> params = new HashMap<>();

        params.put("xParam", String.valueOf(xParam));
        params.put("yParam", String.valueOf(yParam));
        params.put("me", me);
        params.put("thread", Thread.currentThread().getName());

        return params;
    }
}
