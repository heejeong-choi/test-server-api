package com.example.testserverapi.service;

import com.example.testserverapi.common.codes.ErrorCodes;
import com.example.testserverapi.common.handler.ApiException;
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

    private final HostRepository hostRepository;

    //호스트조회
    public Host getById(long hostId) {
        return hostRepository.findById(hostId)
                .orElseThrow(() -> new ApiException("존재하지 않는 호스트입니다.", ErrorCodes.NOT_FOUND_USER));
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

        hostRepository.save(host);

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
