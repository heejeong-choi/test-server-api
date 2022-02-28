package com.example.testserverapi.controller;

import com.example.testserverapi.common.handler.ApiResponse;
import com.example.testserverapi.model.dto.HostReqDto;
import com.example.testserverapi.model.dto.HostResDto;
import com.example.testserverapi.service.HostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/host")
@RequiredArgsConstructor
public class HostController {

    private final HostService hostService;

    //호스트 등록하기 API
    @PostMapping(value = "/register", produces = "application/json; charset=UTF-8")
    public ApiResponse<HostResDto> register(@RequestBody HostReqDto.Registry request) {
        log.info("호스트 등록 REQ :: {}", request.toString());

        HostResDto response = hostService.register(request);

        log.info("호스트 등록 RES :: {}", response.toString());

        return ApiResponse.success(response);
    }

//    @GetMapping(value = "/search/{id}", produces = "application/json; charset=UTF-8")
//    public ApiResponse<HostResDto> search(@PathVariable("id") long hostId) {
//        log.info("호스트 조회 ID :: {}", hostId);
//
//        HostResDto response = hostService.getById(hostId);
//
//        log.info("호스트 조회 RES :: {}", response.toString());
//
//        return ApiResponse.success(response);
//    }

}
