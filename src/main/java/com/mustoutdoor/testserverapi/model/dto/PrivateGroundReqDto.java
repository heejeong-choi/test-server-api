package com.mustoutdoor.testserverapi.model.dto;

import com.mustoutdoor.testserverapi.common.codes.LocationTheme;
import com.mustoutdoor.testserverapi.common.codes.PrivateGroundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

public class PrivateGroundReqDto {

    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Registry {

        private long hostId;
        private String title;
        private String description;
        private List<PrivateGroundType> type;
        private int unitAmount;
        private int accessVehicle;
        private float spaceSize;
        private List<LocationTheme> theme;

    }
}
