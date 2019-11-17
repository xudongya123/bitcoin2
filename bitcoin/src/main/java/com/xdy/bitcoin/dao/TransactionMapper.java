package com.xdy.bitcoin.dao;

import com.github.pagehelper.Page;
import com.xdy.bitcoin.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> selectByBlockId(@Param("blockId") Integer blockId);

    Page<Transaction> selectByBlockIdPage(@Param("blockId") Integer blockId);

}