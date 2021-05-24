package com.example.crawl.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface SubCrawlService {

    CompletableFuture<Void> crawlShareHolder();

}
