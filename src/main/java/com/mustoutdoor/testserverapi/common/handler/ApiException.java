package com.mustoutdoor.testserverapi.common.handler;

import com.mustoutdoor.testserverapi.common.codes.ErrorCodes;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorCodes errorCode;

    public ApiException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getStatusCode() {
        return errorCode.getStatusCode().getCode();
    }

}
