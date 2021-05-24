package com.example.crawl.outgate;

import com.example.crawl.outgate.request.ShareHolderReqModel;
import com.example.crawl.outgate.response.ListLikeResp;
import com.example.crawl.outgate.response.ShareHolderResp;
import com.example.crawl.outgate.response.SingleStockModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ssiClient", url = "${url.cralw.host}")
public interface CrawlClient {

    @GetMapping("${url.crawl.endpoint.defaultallstock}")
    ListLikeResp<SingleStockModel> getAllStock();

    @PostMapping("${url.ssi.endpoint.shareholder}")
    ShareHolderResp getShareHolder(
            @RequestBody ShareHolderReqModel shareHolderReqModel
    );

}
