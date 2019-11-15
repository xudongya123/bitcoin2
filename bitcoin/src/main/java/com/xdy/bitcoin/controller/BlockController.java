package com.xdy.bitcoin.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.xdy.bitcoin.dto.PageDto;
import com.xdy.bitcoin.po.Block;
import com.xdy.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/getRecent")
    public List<JSONObject> getRecent(){
        List<Block> blockss = blockService.getRecent();
        List<JSONObject> blockJsons = blockss.stream().map(block -> {
            JSONObject blockJson = new JSONObject();
            blockJson.put("height", block.getHeight());
            blockJson.put("blockhash", block.getBlockhash());
            blockJson.put("time", block.getTime());
            blockJson.put("miner", block.getMiner());
            blockJson.put("size", block.getSizeondisk());
            return blockJson;
        }).collect(Collectors.toList());
        return blockJsons;
    }
    @GetMapping("/getPage")
    public PageDto<JSONObject> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer page){
        Page<Block> blocks = blockService.getPage(page);
        List<JSONObject> blockJsons = blocks.stream().map(block -> {
            JSONObject blockJson = new JSONObject();
            blockJson.put("height", block.getHeight());
            blockJson.put("blockhash", block.getBlockhash());
            blockJson.put("time", block.getTime());
            blockJson.put("miner", block.getMiner());
            blockJson.put("size", block.getSizeondisk());
            return blockJson;
        }).collect(Collectors.toList());
        PageDto<JSONObject> pageDto = new PageDto<>();
        pageDto.setList(blockJsons);
        pageDto.setTotal(blocks.getTotal());
        pageDto.setPageSize(blocks.getPageSize());
        pageDto.setCurrentPage(blocks.getPageNum());
        return pageDto;
    }

    @GetMapping("/getInfoByHash")
    public JSONObject getInfoByHash(@RequestParam String blockhash){
        return null;
    }

    @GetMapping("/getInfoByHeight")
    public JSONObject getInfoByHeight(@RequestParam Integer height){
        return null;
    }


}
