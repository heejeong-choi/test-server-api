package com.mustoutdoor.testserverapi.common.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum AccessVehicle {

    UP_TO_COMPACT("UP_TO_COMPACT", "light size", true),
    UP_TO_MID ("UP_TO_MID", "large size", true),
    UP_TO_COMPACT_FOR_RV ("UP_TO_COMPACT_FOR_RV", "RV or Trailer (3 pax)", true),
    UP_TO_MID_FOR_RV ("UP_TO_MID_FOR_RV", "large RV or Trailer (5 pax)", true);

    @Getter
    private final String desc;

    @Getter
    private String size;

    @Getter
    private boolean active;

}
