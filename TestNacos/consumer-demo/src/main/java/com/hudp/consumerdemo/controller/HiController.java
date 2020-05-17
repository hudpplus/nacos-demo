package com.hudp.consumerdemo.controller;

import com.hudp.consumerdemo.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("hi")
    public String hi(){
        String hello = this.providerClient.hello();
        return  "hi consumer ==== "+hello;
    }
}
