package com.example.testserverapi.controller;

import com.example.testserverapi.common.handler.ApiResponse;
import com.example.testserverapi.model.dto.PrivateGroundReqDto;
import com.example.testserverapi.model.dto.PrivateGroundResDto;
import com.example.testserverapi.service.PrivateGroundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/private-ground")
@RequiredArgsConstructor
public class PrivateGroundController {

    private final PrivateGroundService privateGroundService;

    @PostMapping(value = "/register", produces = "application/json; charset=UTF-8")
    public ApiResponse<PrivateGroundResDto> register(@RequestBody PrivateGroundReqDto.Registry request) {
        log.info("Private ground 등록 REQ :: {}", request.toString());

        PrivateGroundResDto response = privateGroundService.register(request);

        log.info("Private ground 등록 RES :: {}", response.toString());

        return ApiResponse.success(response);
    }
}
