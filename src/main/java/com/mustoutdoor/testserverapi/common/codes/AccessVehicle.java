package com.mustoutdoor.testserverapi.common.codes;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mustoutdoor.testserverapi.common.handler.CodeEnum;
import com.mustoutdoor.testserverapi.common.handler.CodeEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;


@AllArgsConstructor
public enum AccessVehicle implements CodeEnum {

    UP_TO_COMPACT_FOR_LIGHT_SIZE("UP_TO_COMPACT_LIGHT_SIZE", "light size", true),
    UP_TO_MID_LARGE_SIZE ("UP_TO_MID_LARGE_SIZE", "large size", true),
    UP_TO_COMPACT_FOR_RV_OR_TRAILER ("UP_TO_COMPACT_FOR_RV_OR_TRAILER", "RV or Trailer (3 pax)", true),
    UP_TO_MID_FOR_RV_OR_TRAILER ("UP_TO_COMPACT_FOR_RV_OR_TRAILER", "large RV or Trailer (5 pax)", true);

    @Getter
    private final String code;

    @Getter
    private String desc;

    @Getter
    private boolean active;

    @MappedTypes(AccessVehicle.class)
    public static class TypeHandler extends CodeEnumTypeHandler<AccessVehicle> {
        public TypeHandler() {
            super(AccessVehicle.class);
        }
    }

    @Override
    @JsonValue
    public String getCode() {
        return code;
    }

}
