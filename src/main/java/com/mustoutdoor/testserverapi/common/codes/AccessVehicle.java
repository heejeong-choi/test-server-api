package com.mustoutdoor.testserverapi.common.codes;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mustoutdoor.testserverapi.common.handler.CodeEnum;
import com.mustoutdoor.testserverapi.common.handler.CodeEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;


@AllArgsConstructor
public enum AccessVehicle implements CodeEnum {

    UP_TO_COMPACT("UP_TO_COMPACT", "light size", true),
    UP_TO_MID ("UP_TO_MID", "large size", true),
    UP_TO_COMPACT_FOR_RV ("UP_TO_COMPACT_FOR_RV", "RV or Trailer (3 pax)", true),
    UP_TO_MID_FOR_RV ("UP_TO_MID_FOR_RV", "large RV or Trailer (5 pax)", true);

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
