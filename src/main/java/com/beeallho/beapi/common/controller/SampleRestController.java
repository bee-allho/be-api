package com.beeallho.beapi.common.controller;

import com.beeallho.beapi.common.constants.CommonExceptionType;
import com.beeallho.beapi.common.dto.CommonResponse;
import com.beeallho.beapi.common.utils.ResponseUtils;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class SampleRestController {
    @GetMapping("/sample/ok")
    public ResponseEntity<CommonResponse<?>> sampleOk() {
        return ResponseUtils.createSuccessResponse(SampleResponse.init());
    }

    @GetMapping("/sample/error")
    public ResponseEntity<CommonResponse<?>> sampleError() {
        return ResponseUtils.createFailResponse(CommonExceptionType.UNEXPECTED);
    }

    @Getter
    @Builder
    static class SampleResponse {
        private String name;
        private int age;
        private boolean yn;
        private LocalDateTime createdAt;
        private List<String> roles;
        private SampleAddressResponse address;
        private List<SampleAddressResponse> addressList;

        public static SampleResponse init() {
            return SampleResponse.builder()
                    .name("테스터")
                    .age(20)
                    .yn(true)
                    .createdAt(LocalDateTime.now())
                    .roles(List.of("Super Admin", "Admin", "Employee"))
                    .address(SampleAddressResponse.home())
                    .addressList(List.of(SampleAddressResponse.home(), SampleAddressResponse.office()))
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class SampleAddressResponse {
        private String address;
        private String zipcode;

        public static SampleAddressResponse home() {
            return new SampleAddressResponse("서울시 강서구", "12345");
        }

        public static SampleAddressResponse office() {
            return new SampleAddressResponse("서울시 강남구", "67890");
        }
    }

}
