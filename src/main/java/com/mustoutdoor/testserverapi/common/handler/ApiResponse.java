package com.mustoutdoor.testserverapi.common.handler;

import com.mustoutdoor.testserverapi.common.codes.ErrorCodes;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    public String code;
    public String message;
    public T data;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("", "", data);
    }

    public static <T> ApiResponse<T> error(ErrorCodes errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> ApiResponse<T> error(ErrorCodes errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), message, null);
    }

}
