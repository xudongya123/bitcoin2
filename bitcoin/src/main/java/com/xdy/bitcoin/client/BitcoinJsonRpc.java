package com.xdy.bitcoin.client;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpc {

    JSONObject getRawTransaction(String txid) throws Throwable;

}
