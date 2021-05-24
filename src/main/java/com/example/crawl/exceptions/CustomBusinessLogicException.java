package com.example.crawl.exceptions;

import com.example.crawl.factory.resfact.ResponseStatusEnum;

public class CustomBusinessLogicException  extends ApplicationException{

    private static final long serialVersionUID = -1605187590106478545L;

    public CustomBusinessLogicException(ResponseStatusEnum responseStatusEnum) {
        super(responseStatusEnum);
    }
}
