package com.example.testserverapi.common.codes;

public enum PrivateGroundType {
    PARK ("공원"),
    FARMLAND ("넓은 농경지"),
    FARM ("농장"),
    BARN ("외양간"),
    ORCHARD ("과수원"),
    WINERY ("와인 양조장"),
    QUAYSIDE ("부둣가"),
    SEAWALL ("방조제"),
    FRONT_YARD ("앞마당"),
    OPEN_GROUND ("공지"),
    REST_STOP ("휴게소");

    private String code;
    private String desc;

    PrivateGroundType (String desc) {
        this.code = name();
        this.desc = desc;
    }

}
