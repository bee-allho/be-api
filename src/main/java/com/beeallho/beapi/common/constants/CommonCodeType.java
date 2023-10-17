package com.beeallho.beapi.common.constants;

public interface CommonCodeType {
    String getCode();
    int getStatus();
    String getMessage();
    String getMessage(Object... args);
}
