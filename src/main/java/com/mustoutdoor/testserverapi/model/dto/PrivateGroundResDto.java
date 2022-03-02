package com.mustoutdoor.testserverapi.model.dto;

import com.mustoutdoor.testserverapi.common.codes.AccessVehicle;
import com.mustoutdoor.testserverapi.common.codes.GroundStatus;
import com.mustoutdoor.testserverapi.common.codes.LocationTheme;
import com.mustoutdoor.testserverapi.common.codes.PrivateGroundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrivateGroundResDto {

    private long pgId;
    private long hostId;
    private GroundStatus status;
    private String title;
    private String description;
    private PrivateGroundType type;
    private int unitAmount;
    private AccessVehicle accessVehicle;
    private float spaceSize;
    private String theme;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private boolean deleted;

    @Data
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomResDto {

    }

}
