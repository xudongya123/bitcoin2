package com.xdy.bitcoin.service;

import com.alibaba.fastjson.JSONObject;

public interface TransactionDetailService {
    void syncTxDetailVout(JSONObject vout, Integer transactionId);

    void syncTxDetailVin(JSONObject vin, Integer transactionId);
}
