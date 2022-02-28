package com.mustoutdoor.testserverapi.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum PrivateGroundType {
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
    private final String code;

    @Getter
    private final String desc;

    @Getter
    private final boolean active;

    public static List<PrivateGroundType> privateGroundTypeList() {
        return Arrays.stream(PrivateGroundType.values())
                .filter(PrivateGroundType::isActive)
                .collect(Collectors.toList());
    }

}
