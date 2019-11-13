package io.cjf.bitcoinexplorerback.service;

import org.springframework.scheduling.annotation.Async;

public interface BlockService {

    String syncBlock(String blockhash);

    @Async
    void syncBlocks(String fromBlockhash);
}
