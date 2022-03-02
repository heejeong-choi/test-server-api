package com.mustoutdoor.testserverapi.controller;

import com.mustoutdoor.testserverapi.common.handler.ApiResponse;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundReqDto;
import com.mustoutdoor.testserverapi.model.dto.PrivateGroundResDto;
import com.mustoutdoor.testserverapi.service.PrivateGroundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/search/{pg_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<PrivateGroundResDto> search(@PathVariable("pg_id") long pgId) {
        log.info("Private ground 조회 REQ - private ground ID :: {}", pgId);

        PrivateGroundResDto response = privateGroundService.findByPgId(pgId);

        log.info("Private ground 조회 RES :: {}", response.toString());

        return ApiResponse.success(response);
    }

    //private ground 전체 조회
    @GetMapping(value = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<>

    //private ground 수정하기

    //private ground 숨김처리하기

}
