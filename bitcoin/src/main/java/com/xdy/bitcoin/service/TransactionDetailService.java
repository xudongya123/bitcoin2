package com.xdy.bitcoin.service;

import com.alibaba.fastjson.JSONObject;
import com.xdy.bitcoin.po.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    void syncTxDetailVout(JSONObject vout, Integer transactionId);

    void syncTxDetailVin(JSONObject vin, Integer transactionId);

    List<TransactionDetail> getByTransactionId(Integer transactionId);

    Integer getTotalByAddress(String address);

    Double getReceiveByAddress(String address);

    Double getSendByAddress(String address);

}
