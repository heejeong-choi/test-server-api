package com.mustoutdoor.testserverapi.common.codes;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mustoutdoor.testserverapi.common.handler.CodeEnum;
import com.mustoutdoor.testserverapi.common.handler.CodeEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

@AllArgsConstructor
public enum PrivateGroundType implements CodeEnum {

    PARK ("PARK", "공원", true),
    FARMLAND ("FARMLAND", "넓은 농경지", true),
    FARM ("FARM", "농장", true),
    BARN ("BARN", "외양간", true),
    ORCHARD ("ORCHARD","과수원", true),
    WINERY ("WINERY","와인 양조장", true),
    QUAYSIDE ("QUAYSIDE", "부둣가", true),
    SEAWALL ("SEAWALL","방조제", true),
    FRONT_YARD ("FRONT_YARD", "앞마당", true),
    OPEN_GROUND ("OPEN_GROUND","공지", true),
    REST_STOP ("REST_STOP","휴게소", true);

    @Getter
    private String code;

    @Getter
    private String desc;

    @Getter
    private boolean active;

    @MappedTypes(PrivateGroundType.class)
    public static class TypeHandler extends CodeEnumTypeHandler<PrivateGroundType> {
        public TypeHandler() {
            super(PrivateGroundType.class);
        }
    }

    @Override
    @JsonValue
    public String getCode() {
        return code;
    }

}
