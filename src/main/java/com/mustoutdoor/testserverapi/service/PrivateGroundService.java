package com.mustoutdoor.testserverapi.service;

import com.mustoutdoor.testserverapi.common.codes.ErrorCodes;
import com.mustoutdoor.testserverapi.common.codes.GroundStatus;
import com.mustoutdoor.testserverapi.common.codes.LocationTheme;
import com.mustoutdoor.testserverapi.common.handler.ApiException;
import com.mustoutdoor.testserverapi.common.utils.StringUtil;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundReqDto;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundResDto;
import com.mustoutdoor.testserverapi.model.vo.Host;
import com.mustoutdoor.testserverapi.model.vo.PrivateGround;
import com.mustoutdoor.testserverapi.mapper.PrivateGroundMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrivateGroundService {

    private final PrivateGroundMapper privateGroundMapper;
    private final HostService hostService;

    public PrivateGroundResDto.ForSearch findByPgId(long pgId) {
        return forSearch(privateGroundMapper.findById(pgId));
    }

    public PrivateGroundResDto findById(long pgId) {
        return toDto(privateGroundMapper.findById(pgId));
    }

    public List<PrivateGroundResDto.ForSearch> findAll() throws IllegalArgumentException {
        return privateGroundMapper.findAll()
                .stream()
                .map(this::forSearch)
                .collect(Collectors.toList());
    }

    public PrivateGroundResDto register(PrivateGroundReqDto.Registry form) {
        Host host = hostService.getById(form.getHostId());

        PrivateGround existGround = privateGroundMapper.findByHostId(host.getHostId());

        if(existGround != null) {
            throw new ApiException("해당 호스트는 이미 private ground를 보유하고 있습니다.",
                    ErrorCodes.CONFLICT_EXCEPTION);
        }

        //type은 1개만, theme은 3개까지만
        PrivateGround privateGround = new PrivateGround()
                .setStatus(GroundStatus.ACTIVE)
                .setTitle(form.getTitle())
                .setHostId(host.getHostId())
                .setDescription(form.getDescription())
                .setType(form.getType())
                .setUnitAmount(form.getUnitAmount())
                .setAccessVehicle(form.getAccessVehicle())
                .setSpaceSize(form.getSpaceSize())
                .setTheme(form.getTheme().stream().map(LocationTheme::getCode).collect(Collectors.joining(",")))
                .setCreatedAt(LocalDateTime.now())
                .setCreatedBy(host.getName())
                .setDeleted(false);

        if(form.getTheme().size() > 3) {
            throw new ApiException("Location Theme은 3개까지만 등록이 가능합니다.", ErrorCodes.ONLY_FOR_3_KIND_OF_THEME);
        }

        privateGroundMapper.save(privateGround);
        return toDto(privateGround);
    }

    public PrivateGroundResDto hidePrivateGround(long pgId) {
        PrivateGround privateGround = privateGroundMapper.findById(pgId);
        Host host = hostService.getById(privateGround.getHostId());

        if(privateGround.getStatus() == GroundStatus.ACTIVE) {
            privateGround.setStatus(GroundStatus.INACTIVE)
                    .setModifiedAt(LocalDateTime.now())
                    .setModifiedBy(host.getName());
            privateGroundMapper.hidePrivateGround(pgId);
            return toDto(privateGround);
        } else
            throw new ApiException("숨김처리가 불가능한 Private ground입니다.", ErrorCodes.VALIDATION_EXCEPTION);
    }

    public PrivateGroundResDto toDto(PrivateGround privateGround) {

        PrivateGroundResDto privateGroundDto = new PrivateGroundResDto();

        List<LocationTheme> locationThemeList = new ArrayList<>();
        if (StringUtil.isNotEmpty(privateGround.getTheme())) {
            Arrays.stream(privateGround.getTheme().split(",")).forEach(it -> locationThemeList.add(LocationTheme.valueOf(it)));
        }

        String locationTheme = locationThemeList.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");

        System.out.println(locationTheme);

        return privateGroundDto
                .setPgId(privateGround.getPgId())
                .setStatus(privateGround.getStatus())
                .setTitle(privateGround.getTitle())
                .setDescription(privateGround.getDescription())
                .setType(privateGround.getType())
                .setUnitAmount(privateGround.getUnitAmount())
                .setAccessVehicle(privateGround.getAccessVehicle())
                .setSpaceSize(privateGround.getSpaceSize())
                .setTheme(locationTheme)
                .setCreatedAt(privateGround.getCreatedAt())
                .setCreatedBy(privateGround.getCreatedBy())
                .setModifiedAt(privateGround.getModifiedAt())
                .setModifiedBy(privateGround.getModifiedBy())
                .setDeleted(privateGround.isDeleted());
    }

    public PrivateGroundResDto.ForSearch forSearch(PrivateGround privateGround) {

        PrivateGroundResDto.ForSearch privateGroundDto = new PrivateGroundResDto.ForSearch();
        return privateGroundDto
                .setPgId(privateGround.getPgId())
                .setHostName(privateGround.getCreatedBy())
                .setTitle(privateGround.getTitle())
                .setType(privateGround.getType())
                .setUnitAmount(privateGround.getUnitAmount())
                .setAccessVehicle(privateGround.getAccessVehicle())
                .setSpaceSize(privateGround.getSpaceSize())
                .setTheme(privateGround.getTheme())
                .setCreatedAt(privateGround.getCreatedAt())
                .setDeleted(privateGround.isDeleted());
    }
}
