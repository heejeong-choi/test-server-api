package com.example.testserverapi.model.dto;

import com.example.testserverapi.common.codes.LocationTheme;
import com.example.testserverapi.common.codes.PrivateGroundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PrivateGroundResDto {

    private long pgId;
    private long hostId;
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
