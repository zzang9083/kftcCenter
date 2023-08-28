package com.project.kftcCenter.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class CommonHttpRequestInterceptor extends HandlerInterceptorAdapter {

    public static final String USER_UUID_KEY = "UUID_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        final UUID uuid = UUID.randomUUID();
        MDC.put(USER_UUID_KEY, uuid.toString());

        return true;
    }
}
