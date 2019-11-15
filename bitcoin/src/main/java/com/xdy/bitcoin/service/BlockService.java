package com.xdy.bitcoin.service;

import com.xdy.bitcoin.po.Block;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlockService {

    String syncBlock(String blockhash);


    void syncBlocks(String fromBlockhash);

    List<Block> getRecent();
}
