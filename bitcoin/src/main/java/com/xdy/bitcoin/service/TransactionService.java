package com.xdy.bitcoin.service;

public interface TransactionService {
    void syncTransaction(String txid, Integer blockId, Long time);
}
