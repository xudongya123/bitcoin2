package com.xdy.bitcoin.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xdy.bitcoin.client.BitcoinRest;
import com.xdy.bitcoin.dao.TransactionMapper;;
import com.xdy.bitcoin.enumeration.TxDetailType;
import com.xdy.bitcoin.po.Transaction;
import com.xdy.bitcoin.po.TransactionDetail;
import com.xdy.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailServiceImpl transactionDetailService;

    @Override
    public void syncTransaction(String txid, Integer blockId, Long time) {
        JSONObject transactionJson = bitcoinRest.getTransaction(txid);
        Transaction transaction = new Transaction();
        transaction.setBlockId(blockId);
        transaction.setSizeondisk(transactionJson.getInteger("size"));
        transaction.setStatus((byte)0);
        transaction.setTime(time);
        transaction.setTxhash(transactionJson.getString("hash"));
        transaction.setTxid(transactionJson.getString("txid"));
        transaction.setWeight(transactionJson.getInteger("weight"));

        transactionMapper.insert(transaction);

        Integer transactionId = transaction.getTransactionId();

        List<JSONObject> vouts = transactionJson.getJSONArray("vout").toJavaList(JSONObject.class);
        for (JSONObject vout : vouts) {
            transactionDetailService.syncTxDetailVout(vout, transactionId);
        }
        List<JSONObject> vins = transactionJson.getJSONArray("vin").toJavaList(JSONObject.class);
        for (JSONObject vin : vins) {
            transactionDetailService.syncTxDetailVin(vin, transactionId);
        }

    }
}
