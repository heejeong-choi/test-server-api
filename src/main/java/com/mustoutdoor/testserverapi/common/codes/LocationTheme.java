package com.mustoutdoor.testserverapi.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public enum LocationTheme {

    FOREST("FOREST", "숲", true),
    MOUNTAIN ("MOUNTAIN", "산", true),
    HILL_SIDE ("HILL_SIDE", "비탈", true),
    RIVER_VIEW ("RIVER_VIEW", "강가", true),
    LAKE_VIEW ("LAKE_VIEW", "호수", true),
    STREAM_SIDE ("STREAM_SIDE", "강기슭", true),
    BEACH_FRONT ("BEACH_FRONT", "해변가", true),
    VALLEY ("VALLEY", "계곡", true),
    COUNTRYSIDE ("COUNTRYSIDE", "시골가", true),
    ISLAND ("ISLAND", "섬", true),
    URBAN_CITY ("URBAN_CITY", "도시", true),
    DESERT ("DESERT", "사막", true),
    EVENT_AND_PARTY ("EVENT_AND_PARTY", "행사 공간", true),
    FAMILY_FRIENDLY ("FAMILY_FRIENDLY", "가족 중심", true),
    COUPLE_FRIENDLY ("COUPLE_FRIENDLY", "커플 중심", true),
    HOT_SPRING ("HOT_SPRING", "온천", true),
    PET_ALLOWED ("PET_ALLOWED", "애완동물 동반가능", true);

    @Getter
    private String code;

    @Getter
    private String desc;

    @Getter
    private boolean active;

    public static List<LocationTheme> locationThemeList() {
        return Arrays.stream(LocationTheme.values())
                .filter(LocationTheme::isActive)
                .collect(Collectors.toList());
    }
}
