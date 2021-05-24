package com.example.crawl.service.impl;

import com.example.crawl.outgate.CrawlClient;
import com.example.crawl.outgate.request.ShareHolderReqModel;
import com.example.crawl.outgate.response.ShareHolderModel;
import com.example.crawl.outgate.response.ShareHolderResp;
import com.example.crawl.outgate.response.SingleStockModel;
import com.example.crawl.repository.ShareHolderRepository;
import com.example.crawl.repository.entity.ShareHolder;
import com.example.crawl.service.SubCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class SubCrawlServiceImpl implements SubCrawlService {

    private final CrawlClient crawlClient;
    private final ShareHolderRepository shareHolderRepository;

    @Autowired
    public SubCrawlServiceImpl(
            CrawlClient crawlClient,
            ShareHolderRepository shareHolderRepository
    ) {
        this.crawlClient = crawlClient;
        this.shareHolderRepository = shareHolderRepository;
    }

    private void saveShareHolderToDb(String symbol, ShareHolderModel shareHolderModel) {
        ShareHolder shareHolder = new ShareHolder();
        BeanUtils.copyProperties(shareHolderModel, shareHolder);
        shareHolder.setSymbol(symbol);

        try {
            shareHolderRepository.save(shareHolder);
        } catch (Exception e) {
            log.info("Failed to save shareholder to db {} , {} - {}", shareHolder, e.getMessage(), e.getCause());
        }
    }

    private void crawlAndSaveShareHolder(String symbol) {
        ShareHolderReqModel shareHolderReqModel = new ShareHolderReqModel();
        shareHolderReqModel.setSymbol(symbol);
        shareHolderReqModel.setSize(1000000);
        shareHolderReqModel.setOffset(1);

        try {
            ShareHolderResp shareHolderResp = crawlClient.getShareHolder(shareHolderReqModel);
            shareHolderResp.getData().getShareHolders().getDataList().forEach(item -> saveShareHolderToDb(symbol, item));
        } catch (Exception e) {
            log.info("Failed to crawl shareholder --> {} - {}", e.getMessage(), e.getCause());
        }
    }

    @Override
    public CompletableFuture<Void> crawlShareHolder() {
        return CompletableFuture.runAsync(() -> {
            List<SingleStockModel> listSingleStock = crawlClient.getAllStock().getData();
            listSingleStock.forEach(item -> crawlAndSaveShareHolder(item.getCode()));
        });
    }

}
