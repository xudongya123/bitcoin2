package com.xdy.bitcoin.service;

import com.github.pagehelper.Page;
import com.xdy.bitcoin.po.Transaction;

import java.util.List;

public interface TransactionService {
    void syncTransaction(String txid, Integer blockId, Long time);

    List<Transaction> getByBlockId(Integer blockId);

    Page<Transaction> getByBlockIdPage(Integer blockId,Integer page);

    Transaction getByTxid(String txid);

    Page<Transaction> getTransactionByAddressPage(String address, Integer page);


}

