package com.example.testserverapi.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PrivateGround {
    private long pgId;
    private long hostId;
    private String title;
    private String description;
    private String type;
    private int unitAmount;
    private int accessVehicle;
    private float spaceSize;
    private String theme;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private boolean deleted;
}
