package com.beeallho.beapi.common.constants;

import com.beeallho.beapi.common.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum CommonExceptionType implements CommonCodeType {
    // standard
    BAD_REQUEST("301", HttpStatus.BAD_REQUEST.value(), "exception.standard.badRequest"),
    UNAUTHORIZED("302", HttpStatus.UNAUTHORIZED.value(), "exception.standard.unauthorized"),
    FORBIDDEN("303", HttpStatus.FORBIDDEN.value(), "exception.standard.forbidden"),
    NOT_FOUND("304", HttpStatus.NOT_FOUND.value(), "exception.standard.notFound"),
    UNEXPECTED("305", HttpStatus.INTERNAL_SERVER_ERROR.value(), "exception.standard.unexpected"),

    // common
    NOT_IMPLEMENTED("311", HttpStatus.INTERNAL_SERVER_ERROR.value(), "exception.standard.unexpected"),
    DUPLICATE_PK("312", HttpStatus.BAD_REQUEST.value(), "exception.common.duplicate.pk"),
    NO_PERMISSION_EDIT("313", HttpStatus.UNAUTHORIZED.value(), "exception.common.noPermission.edit"),
    INVALID_RETRIEVE_DATE("314", HttpStatus.BAD_REQUEST.value(), "exception.common.invalid.retrieveDate")
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
