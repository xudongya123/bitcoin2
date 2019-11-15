package com.xdy.bitcoin.controller;

import com.alibaba.fastjson.JSONObject;
import com.xdy.bitcoin.client.BitcoinRest;
import com.xdy.bitcoin.client.Bitcoinjson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.basic.BasicIconFactory;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private Bitcoinjson bitcoinJsonRpc;

    @GetMapping("/hello")
    public String hello() throws Throwable {
        JSONObject jsonObject = bitcoinJsonRpc.getTransaction("6e9457c769b4a91af5bd28faec8dca78bf8e49c439784279c24db5d827583447");
        return null;
    }
}
