package com.example.crawl.outgate.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShareHolderWrapper {
    @JsonProperty("dataList")
    private List<ShareHolderModel> dataList;
}
