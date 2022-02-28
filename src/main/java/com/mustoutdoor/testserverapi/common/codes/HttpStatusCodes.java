package com.mustoutdoor.testserverapi.common.codes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum HttpStatusCodes {

    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    UNSUPPORTED_MEDIA_TYPE(415),
    INTERNAL_SERVER(500),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503);

    private final int code;
}