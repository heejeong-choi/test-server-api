package com.mustoutdoor.testserverapi.controller;

import com.mustoutdoor.testserverapi.common.codes.ErrorCodes;
import com.mustoutdoor.testserverapi.common.handler.ApiException;
import com.mustoutdoor.testserverapi.common.handler.ApiResponse;
import com.mustoutdoor.testserverapi.service.HostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@CrossOrigin
public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponse processValidationError(MethodArgumentNotValidException ex) {
        FieldError fieldError = (FieldError) ex.getBindingResult().getFieldErrors().get(0);
        return ApiResponse.error(ErrorCodes.VALIDATION_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler({ApiException.class})
    public ApiResponse handleApiException(Exception e) {
        log.error("ApiException ::: {}", e.getMessage());
        e.printStackTrace();
        return ApiResponse.error(ErrorCodes.CONFLICT_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ApiResponse handleException(Exception e) {
        log.error("Exception ::: {}", e.getMessage());
        e.printStackTrace();
        return ApiResponse.error(ErrorCodes.SERVER_EXCEPTION);
    }

}
