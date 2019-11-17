package com.xdy.bitcoin.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.xdy.bitcoin.constarts.PageConfig;
import com.xdy.bitcoin.dto.PageDTO;
import com.xdy.bitcoin.po.Block;
import com.xdy.bitcoin.po.Transaction;
import com.xdy.bitcoin.po.TransactionDetail;
import com.xdy.bitcoin.service.BlockService;
import com.xdy.bitcoin.service.TransactionDetailService;
import com.xdy.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private BlockService blockService;

    @Autowired
    private TransactionDetailService transactionDetailService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getRecentUnconfirmed")
    public List<JSONObject> getRecentUnconfirmed(@RequestParam(required = false, defaultValue = "20") Integer size){
        return null;
    }

    @GetMapping("/getByTxid")
    public JSONObject getByTxhash(@RequestParam String txid){
        Transaction tx = transactionService.getByTxid(txid);
        JSONObject txJson = new JSONObject();
        txJson.put("txid", tx.getTxid());
        txJson.put("txhash", tx.getTxhash());
        txJson.put("time", tx.getTime());
        txJson.put("fees", tx.getFees());
        txJson.put("totalOutput", tx.getTotalOutput());

        List<TransactionDetail> txDetails = transactionDetailService.getByTransactionId(tx.getTransactionId());
        List<JSONObject> txDetailJsons = txDetails.stream().map(txDetail -> {
            JSONObject txDetailJson = new JSONObject();
            txDetailJson.put("address", txDetail.getAddress());
            txDetailJson.put("type", txDetail.getType());
            txDetailJson.put("amount", Math.abs(txDetail.getAmount()));
            return txDetailJson;
        }).collect(Collectors.toList());
        txJson.put("txDetails", txDetailJsons);
        return txJson;
    }

    @GetMapping("/getByBlockhashPage")
    public PageDTO<JSONObject> getByBlockhashPage(@RequestParam String blockhash,@RequestParam(required = false,defaultValue = "1") Integer page){
     Block block= blockService.getByBlockhash(blockhash);
     Integer blockId = block.getBlockId();
     Page<Transaction> pageXt = transactionService.getByBlockIdPage(blockId, page);
        List<JSONObject> txJsons = pageXt.stream().map(tx -> {
            JSONObject txJson = new JSONObject();
            txJson.put("txid", tx.getTxid());
            txJson.put("txhash", tx.getTxhash());
            txJson.put("time", tx.getTime());
            txJson.put("fees", tx.getFees());
            txJson.put("totalOutput", tx.getTotalOutput());

            List<TransactionDetail> txDetails = transactionDetailService.getByTransactionId(tx.getTransactionId());
            List<JSONObject> txDetailJsons = txDetails.stream().map(txDetail -> {
                JSONObject txDetailJson = new JSONObject();
                txDetailJson.put("address", txDetail.getAddress());
                txDetailJson.put("type", txDetail.getType());
                txDetailJson.put("amount", Math.abs(txDetail.getAmount()));
                return txDetailJson;
            }).collect(Collectors.toList());
            txJson.put("txDetails", txDetailJsons);
            return txJson;
        }).collect(Collectors.toList());

     PageDTO<JSONObject> pageDTO=new PageDTO<>();
     pageDTO.setTotal(pageXt.getTotal());
     pageDTO.setPageSize(PageConfig.PAGE_SIZE);
     pageDTO.setCurrentPage(pageXt.getPageNum());
     pageDTO.setList(txJsons);
     return pageDTO;
    }


}
