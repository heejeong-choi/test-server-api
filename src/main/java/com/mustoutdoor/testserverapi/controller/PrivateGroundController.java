package com.mustoutdoor.testserverapi.controller;

import com.mustoutdoor.testserverapi.common.handler.ApiResponse;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundReqDto;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundResDto;
import com.mustoutdoor.testserverapi.service.PrivateGroundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<PrivateGroundResDto> register(@RequestBody PrivateGroundReqDto.Registry request) {
        log.info("Private ground 등록 REQ :: {}", request.toString());

        PrivateGroundResDto response = privateGroundService.register(request);

        log.info("Private ground 등록 RES :: {}", response.toString());

        return ApiResponse.success(response);
    }
}
