package com.mustoutdoor.testserverapi.controller;

import com.mustoutdoor.testserverapi.common.handler.ApiResponse;
import com.mustoutdoor.testserverapi.model.dto.HostReqDto;
import com.mustoutdoor.testserverapi.model.dto.HostResDto;
import com.mustoutdoor.testserverapi.service.HostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/host")
@Component
@RequiredArgsConstructor
public class HostController extends BaseController {

    private final HostService hostService;

    //호스트 등록하기 API
    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<HostResDto> register(@RequestBody HostReqDto.Registry request) {
        log.info("호스트 등록 REQ :: {}", request.toString());

        HostResDto response = hostService.register(request);

        log.info("호스트 등록 RES :: {}", response.toString());

        return ApiResponse.success(response);
    }

    @PatchMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<HostResDto> register(@RequestBody HostReqDto.UpdateForm request) {
        log.info("호스트 정보 수정 REQ :: {}", request.toString());

        return ApiResponse.success(new HostResDto());
    }

    //호스트 탈퇴하기 기능
    @DeleteMapping(value = "/delete/{host_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse delete(@PathVariable (name = "host_id") long hostId) {
        log.info("탈퇴를 원하는 호스트 ID값 REQ :: {}", hostId);

        hostService.deleteHost(hostId);

        log.info("탈퇴 RES :: OK");

        return ApiResponse.success("OK");
    }

}
