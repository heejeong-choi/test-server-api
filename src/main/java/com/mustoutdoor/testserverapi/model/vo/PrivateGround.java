package com.mustoutdoor.testserverapi.model.vo;

import com.mustoutdoor.testserverapi.common.codes.AccessVehicle;
import com.mustoutdoor.testserverapi.common.codes.GroundStatus;
import com.mustoutdoor.testserverapi.common.codes.LocationTheme;
import com.mustoutdoor.testserverapi.common.codes.PrivateGroundType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PrivateGround {

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

}
