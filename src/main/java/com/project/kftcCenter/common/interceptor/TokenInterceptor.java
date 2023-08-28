package com.project.kftcCenter.common.interceptor;

import com.project.kftcCenter.application.funtion.TokenUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    private final TokenUtil tokenUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = extractJwtTokenFromHeader(request);
        request.get
        Claims claimsByToken = TokenUtil.getClaimsByToken(token);

        String secuCdn = claimsByToken.getSubject();
        userService.getUser(payload.getUserId());
        
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private String extractJwtTokenFromHeader(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new AuthenticationException();
        }
        return authorization;
    }
}
