package com.xdy.bitcoin.dao;

import com.github.pagehelper.Page;
import com.xdy.bitcoin.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecent();

    Page<Block> selectWithPage();

    Block selectByBlockhash(@Param("blockhash") String blockhash);

}