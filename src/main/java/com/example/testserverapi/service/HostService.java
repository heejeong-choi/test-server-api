package com.example.testserverapi.service;

import com.example.testserverapi.repository.HostRepository;
import com.example.testserverapi.model.dto.HostReqDto;
import com.example.testserverapi.model.dto.HostResDto;
import com.example.testserverapi.model.vo.Host;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostMapper;

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
