package com.xdy.bitcoin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class MiscController {


    @GetMapping("/search")
    public String search(String keyword){
        return null;
    }
}
