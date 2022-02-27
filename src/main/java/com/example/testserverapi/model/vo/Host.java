package com.example.testserverapi.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Host {
    private Long hostId;
    private String name;
    private String email;
    private String imageUrl;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
    private boolean deleted;
}
