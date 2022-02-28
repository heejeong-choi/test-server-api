package com.example.testserverapi.service;

import com.example.testserverapi.common.codes.LocationTheme;
import com.example.testserverapi.common.codes.PrivateGroundType;
import com.example.testserverapi.model.dto.PrivateGroundReqDto;
import com.example.testserverapi.model.dto.PrivateGroundResDto;
import com.example.testserverapi.model.vo.Host;
import com.example.testserverapi.model.vo.PrivateGround;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Slf4j
@Service
public class PrivateGroundService {

    public PrivateGroundResDto register(PrivateGroundReqDto.Registry form) {
        PrivateGround privateGround = new PrivateGround()
                .setTitle(form.getTitle())
                .setDescription(form.getDescription())
                .setType(form.getType().stream().map(PrivateGroundType::getCode).collect(Collectors.joining(",")))
                .setUnitAmount(form.getUnitAmount())
                .setAccessVehicle(form.getAccessVehicle())
                .setSpaceSize(form.getSpaceSize())
                .setTheme(form.getTheme().stream().map(LocationTheme::getCode).collect(Collectors.joining(",")))
                .setCreatedAt(LocalDateTime.now())
                .setDeleted(false);

    }

    public PrivateGroundResDto toDto(PrivateGround privateGround) {
        PrivateGroundResDto privateGroundResDto = new PrivateGroundResDto();

        List<PrivateGroundType> privateGroundTypes = new ArrayList<>();
        if(!isEmpty(privateGround.getType()))
        return new PrivateGroundResDto()
                .setPgId(privateGround.getPgId())
                .setTitle(privateGround.getTitle())
                .setDescription(privateGround.getDescription())
                .setType(privateGround.getType())
                .setUnitAmount(privateGround.getUnitAmount())
                .setAccessVehicle(privateGround.getAccessVehicle())
                .setSpaceSize(privateGround.getSpaceSize())
                .setTheme(privateGround.getTheme())
                .setCreatedAt(privateGround.getCreatedAt())
                .setCreatedBy(privateGround.getCreatedBy())
                .setModifiedAt(privateGround.getModifiedAt())
                .setModifiedBy(privateGround.getModifiedBy())
                .setDeleted(privateGround.isDeleted());
    }

    public static boolean isEmpty(@Nullable String str) {
        return (str == null || "".equals(str) || "undefined".equals(str.toLowerCase()) || "undefined".equals(str.toUpperCase()));
    }
}
