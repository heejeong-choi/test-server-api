package com.mustoutdoor.testserverapi.common.codes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.mustoutdoor.testserverapi.common.codes.HttpStatusCodes.*;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCodes {

    // 400 Bad Request
    VALIDATION_EXCEPTION(BAD_REQUEST, "VA01", "잘못된 요청입니다."),
    ONLY_FOR_3_KIND_OF_THEME(BAD_REQUEST, "VA02", "위치 테마는 3개까지만 선택이 가능합니다."),

    // 403 Forbidden
    FORBIDDEN_EXCEPTION(FORBIDDEN, "FB01", "허용되지 않는 요청입니다."),

    // 404 Not Found
    NOT_FOUND(HttpStatusCodes.NOT_FOUND, "NF01", "존재하지 않습니다."),
    NOT_FOUND_USER(HttpStatusCodes.NOT_FOUND, "NF03", "존재하지 않는 사용자입니다."),

    // 409 Conflict
    CONFLICT_EXCEPTION(CONFLICT,  "CF01","이미 존재합니다."),

    // 500 Server Exception
    SERVER_EXCEPTION(INTERNAL_SERVER, "SE01", "예상치 못한 에러가 발생했습니다.\n잠시 후 다시 시도해주세요. "),

    // 502 Bad Gateway
    BAD_GATEWAY_EXCEPTION(BAD_GATEWAY, "BG01", "일시적인 에러가 발생했습니다.\n잠시 후 다시 시도해주세요."),

    // 503 Server UnAvailable
    SERVER_UNAVAILABLE_EXCEPTION(SERVICE_UNAVAILABLE,  "SU01","서버가 점검중 입니다.\n잠시 후 다시 시도해주세요.");


    private final HttpStatusCodes statusCode;
    private final String code;
    private final String message;

}