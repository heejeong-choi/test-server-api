package com.mustoutdoor.testserverapi.common.codes;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mustoutdoor.testserverapi.common.handler.CodeEnum;
import com.mustoutdoor.testserverapi.common.handler.CodeEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

@AllArgsConstructor
public enum GroundStatus implements CodeEnum {

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

    @MappedTypes(GroundStatus.class)
    public static class TypeHandler extends CodeEnumTypeHandler<GroundStatus> {
        public TypeHandler() {
            super(GroundStatus.class);
        }
    }

    @Override
    @JsonValue
    public String getCode() {
        return code;
    }

}
