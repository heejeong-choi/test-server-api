package com.mustoutdoor.testserverapi.service;

import com.mustoutdoor.testserverapi.common.codes.LocationTheme;
import com.mustoutdoor.testserverapi.common.codes.PrivateGroundType;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundReqDto;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundResDto;
import com.mustoutdoor.testserverapi.model.vo.Host;
import com.mustoutdoor.testserverapi.model.vo.PrivateGround;
import com.mustoutdoor.testserverapi.mapper.PrivateGroundMapper;
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
