package com.example.testserverapi.model.dto;

import com.example.testserverapi.common.codes.LocationTheme;
import com.example.testserverapi.common.codes.PrivateGroundType;
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
        private Long pgId;
        private String title;
        private String description;
        private List<PrivateGroundType> type;
        private int unitAmount;
        private int accessVehicle;
        private float spaceSize;
        private List<LocationTheme> theme;
    }

}
