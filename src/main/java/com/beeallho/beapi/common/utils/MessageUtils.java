package com.beeallho.beapi.common.utils;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtils {
    @Resource
    private MessageSource _messageSource;

    static MessageSource messageSource;

    @PostConstruct
    public void initialize() {
        messageSource = _messageSource;
    }

    public static String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, code, Locale.getDefault());
    }
}
