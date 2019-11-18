package com.xdy.bitcoin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xdy.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private TransactionDetailService transactionDetailService;


    @GetMapping("/getInfoByAddress")
    public JSONObject getInfoByAddress(@RequestParam String address){

        Integer txTotal = transactionDetailService.getTotalByAddress(address);
        JSONObject addressInfojson = new JSONObject();
        addressInfojson.put("txSize",txTotal);

        return addressInfojson;
    }
}
