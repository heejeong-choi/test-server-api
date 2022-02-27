package com.example.testserverapi.model.vo;

import com.example.testserverapi.common.codes.LocationTheme;
import com.example.testserverapi.common.codes.PrivateGroundType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PrivateGround {
    private Long pgId;
    private Long hostId;
    private String title;
    private String description;
    private PrivateGroundType type;
    private int unitAmount;
    private int accessVehicle;
    private float spaceSize;
    private LocationTheme theme;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private boolean deleted;
}
