package com.example.crawl.schedulers;

import com.example.crawl.service.SubCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class ShareholderCrawlSchedule {

    private final SubCrawlService subCrawlService;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public ShareholderCrawlSchedule(
            SubCrawlService subCrawlService
    ) {
        this.subCrawlService = subCrawlService;
    }

    @Scheduled(cron = "${crawl.cron}")
    public void crawlEach12Hour() {
        LocalDateTime now = LocalDateTime.now();
        log.info("Start crawl share-holder at {} ", dtf.format(now));
        subCrawlService.crawlShareHolder().join();
        log.info("Done crawl share-holder at {} ", dtf.format(now));
    }

}
