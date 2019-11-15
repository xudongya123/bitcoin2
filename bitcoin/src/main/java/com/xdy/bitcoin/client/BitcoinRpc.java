package com.xdy.bitcoin.client;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinRpc {
    JSONObject getTransaction(String txid) throws Throwable;

}
