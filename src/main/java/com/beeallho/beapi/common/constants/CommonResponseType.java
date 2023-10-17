package com.beeallho.beapi.common.constants;

import com.beeallho.beapi.common.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CommonResponseType implements CommonCodeType {
    OK("200", HttpStatus.OK.value(), "message.common.ok")
    ;

    private final String code;
    private final int status;
    private final String messageCode;

    public String getCode() {
        return code + status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return MessageUtils.getMessage(messageCode);
    }

    public String getMessage(Object... args) {
        return MessageUtils.getMessage(messageCode, args);
    }

}
