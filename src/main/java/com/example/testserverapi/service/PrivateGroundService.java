package com.example.testserverapi.service;

import com.example.testserverapi.common.codes.LocationTheme;
import com.example.testserverapi.common.codes.PrivateGroundType;
import com.example.testserverapi.model.dto.PrivateGroundReqDto;
import com.example.testserverapi.model.dto.PrivateGroundResDto;
import com.example.testserverapi.model.vo.Host;
import com.example.testserverapi.model.vo.PrivateGround;
import com.example.testserverapi.mapper.PrivateGroundMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrivateGroundService {

    private final PrivateGroundMapper privateGroundMapper;
    private final HostService hostService;

    public PrivateGroundResDto register(PrivateGroundReqDto.Registry form) {
        Host host = hostService.getById(form.getHostId());

        PrivateGround privateGround = new PrivateGround()
                .setTitle(form.getTitle())
                .setHostId(host.getHostId())
                .setDescription(form.getDescription())
                .setType(form.getType().stream().map(PrivateGroundType::getCode).collect(Collectors.joining(",")))
                .setUnitAmount(form.getUnitAmount())
                .setAccessVehicle(form.getAccessVehicle())
                .setSpaceSize(form.getSpaceSize())
                .setTheme(form.getTheme().stream().map(LocationTheme::getCode).collect(Collectors.joining(",")))
                .setCreatedAt(LocalDateTime.now())
                .setDeleted(false);

        privateGroundMapper.save(privateGround);

        return toDto(privateGround);
    }

    public PrivateGroundResDto toDto(PrivateGround privateGround) {
        return new PrivateGroundResDto()
                .setPgId(privateGround.getPgId())
                .setTitle(privateGround.getTitle())
                .setDescription(privateGround.getDescription())
                .setType(PrivateGroundType.valueOf(privateGround.getType()))
                .setUnitAmount(privateGround.getUnitAmount())
                .setAccessVehicle(privateGround.getAccessVehicle())
                .setSpaceSize(privateGround.getSpaceSize())
                .setTheme(LocationTheme.valueOf(privateGround.getTheme()))
                .setCreatedAt(privateGround.getCreatedAt())
                .setCreatedBy(privateGround.getCreatedBy())
                .setModifiedAt(privateGround.getModifiedAt())
                .setModifiedBy(privateGround.getModifiedBy())
                .setDeleted(privateGround.isDeleted());
    }
}
