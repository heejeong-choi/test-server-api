package com.mustoutdoor.testserverapi.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Host {
    private long hostId;
    private String name;
    private String email;
    private String imageUrl;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private boolean deleted;
}
