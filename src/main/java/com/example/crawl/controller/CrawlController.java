package com.example.crawl.controller;


import com.example.crawl.factory.resfact.GeneralResponse;
import com.example.crawl.factory.resfact.ResponseFactory;
import com.example.crawl.service.SubCrawlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@Slf4j
@RestController
@RequestMapping(path = "/external/crawler/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class CrawlController {

    private final SubCrawlService subCrawlService;

    @Autowired
    public CrawlController(
            SubCrawlService subCrawlService
    ) {
        this.subCrawlService = subCrawlService;
    }

    @GetMapping("/crawl-shareholder")
    public ResponseEntity<GeneralResponse<Object>> crawlShareHolder() {
        subCrawlService.crawlShareHolder();
        return ResponseFactory.success();
    }

}
