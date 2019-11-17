package com.xdy.bitcoin.service;

import com.github.pagehelper.Page;
import com.xdy.bitcoin.po.Block;

import java.util.List;

public interface BlockService {

    String syncBlock(String blockhash);

    void syncBlocks(String fromBlockhash);

    List<Block> getRecent();

    Page<Block> getWithPage(Integer page);

    Block getByBlockhash(String blockhash);
}
