package com.example.testserverapi.common.codes;

public enum LocationTheme {

    FOREST("숲"),
    MOUNTAIN ("산"),
    HILL_SIDE ("비탈"),
    RIVER_VIEW ("강가"),
    LAKE_VIEW ("호수"),
    STREAM_SIDE ("강기슭"),
    BEACH_FRONT ("해변가"),
    VALLEY ("계곡"),
    COUNTRYSIDE ("시골가"),
    ISLAND ("섬"),
    URBAN_CITY ("도시"),
    DESERT ("사막"),
    EVENT_AND_PARTY ("행사 공간"),
    FAMILY_FRIENDLY ("가족 중심"),
    COUPLE_FRIENDLY ("커플 중심"),
    HOT_SPRING ("온천"),
    PET_ALLOWED ("애완동물 동반가능");

    private String code;
    private String desc;

    LocationTheme (String desc) {
        this.code = name();
        this.desc = desc;
    }
}
