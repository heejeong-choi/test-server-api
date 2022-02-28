package com.mustoutdoor.testserverapi.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GroundStatus {

    ACTIVE ("ACTIVE", "공개된 private ground", true),
    INACTIVE ("INACTIVE", "숨김처리 된 private ground", true),
    DELETED("DELETED", "삭제된 private ground", true),
    UNDER_INSPECTION("UNDER_INSPECTION", "검사중인 private ground", true);

    @Getter
    private final String code;

    @Getter
    private String desc;

    @Getter
    private boolean active;

}
