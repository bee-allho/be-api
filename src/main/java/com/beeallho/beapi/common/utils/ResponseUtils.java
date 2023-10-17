package com.beeallho.beapi.common.utils;

import com.beeallho.beapi.common.constants.CommonExceptionType;
import com.beeallho.beapi.common.constants.CommonResponseType;
import com.beeallho.beapi.common.dto.CommonResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtils {
    // 정상 응답
    public static <T> ResponseEntity<CommonResponse<?>> createSuccessResponse(T data) {
        return createSuccessResponse(CommonResponseType.OK.getCode(), CommonResponseType.OK.getMessage(), data, HttpStatus.OK);
    }

    public static ResponseEntity<CommonResponse<?>> createSuccessResponse(CommonResponseType type) {
        return createSuccessResponse(type, new Object());
    }

    public static ResponseEntity<CommonResponse<?>> createSuccessResponse(CommonResponseType type, Object... args) {
        return createSuccessResponse(type.getCode(), type.getMessage(args), new Object(), HttpStatus.OK);
    }

    private static <T> ResponseEntity<CommonResponse<?>> createSuccessResponse(String code, String message, T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new CommonResponse<>(code, message, data), httpStatus);
    }

    // 에러 응답
    public static ResponseEntity<CommonResponse<?>> createFailResponse(CommonExceptionType type) {
        return createFailResponse(type, new Object());
    }

    public static ResponseEntity<CommonResponse<?>> createFailResponse(CommonExceptionType type, Object... args) {
        return createFailResponse(type.getCode(), type.getMessage(args), HttpStatus.valueOf(type.getStatus()));
    }

    private static <T> ResponseEntity<CommonResponse<?>> createFailResponse(String code, String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(new CommonResponse<>(code, message, null), httpStatus);
    }
}
