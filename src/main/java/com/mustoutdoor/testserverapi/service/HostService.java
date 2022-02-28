package com.mustoutdoor.testserverapi.service;

import com.mustoutdoor.testserverapi.mapper.HostMapper;
import com.mustoutdoor.testserverapi.model.dto.HostReqDto;
import com.mustoutdoor.testserverapi.model.dto.HostResDto;
import com.mustoutdoor.testserverapi.model.vo.Host;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class HostService {

    private final HostMapper hostMapper;

    //호스트조회
    public Host getById(long hostId) {
        return hostMapper.findById(hostId);
    }

    //호스트 등록
    public HostResDto register(HostReqDto.Registry request) {
        Host host = new Host()
                .setName(request.getName())
                .setEmail(request.getEmail())
                .setImageUrl(request.getImageUrl())
                .setCreatedAt(LocalDateTime.now())
                .setCreatedBy(request.getName())
                .setDeleted(false);

        hostMapper.save(host);

        return toDto(host);
    }

    public HostResDto toDto(Host host) {
        return new HostResDto()
                .setHostId(host.getHostId())
                .setName(host.getName())
                .setEmail(host.getEmail())
                .setImageUrl(host.getImageUrl())
                .setCreatedAt(host.getCreatedAt())
                .setCreatedBy(host.getCreatedBy())
                .setModifiedAt(host.getModifiedAt())
                .setModifiedBy(host.getModifiedBy())
                .setDeleted(host.isDeleted());
    }
}
