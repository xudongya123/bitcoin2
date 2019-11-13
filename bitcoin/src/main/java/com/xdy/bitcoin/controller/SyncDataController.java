package io.cjf.bitcoinexplorerback.controller;

import com.alibaba.fastjson.JSONObject;
import io.cjf.bitcoinexplorerback.client.BitcoinRest;
import io.cjf.bitcoinexplorerback.dao.BlockMapper;
import io.cjf.bitcoinexplorerback.po.Block;
import io.cjf.bitcoinexplorerback.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/syncdata")
@EnableAutoConfiguration
public class SyncDataController {

    @Autowired
    private BlockService blockService;

    @PostMapping("/fullImport")
    public void fullImport(@RequestParam(required = false, defaultValue = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943") String blockhash){
        blockService.syncBlocks(blockhash);
    }
}
