package com.example.crawl.outgate.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShareHolderResp {

    @JsonProperty("data")
    private ShareHolderPaging data;

}
