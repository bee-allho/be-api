package com.beeallho.beapi.common.dto;

public record CommonResponse<T>(
        String code,
        String message,
        T data
) {
}
