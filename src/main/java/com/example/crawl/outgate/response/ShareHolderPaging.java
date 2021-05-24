package com.example.crawl.outgate.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShareHolderPaging {

    @JsonProperty("shareholders")
    private ShareHolderWrapper shareHolders;

}
