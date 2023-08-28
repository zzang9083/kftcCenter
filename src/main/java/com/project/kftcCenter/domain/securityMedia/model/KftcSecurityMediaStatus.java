package com.project.kftcCenter.domain.securityMedia.model;

import lombok.Getter;

@Getter
public enum KftcSecurityMediaStatus {

    STATUS_REGISTER("000", "등록"),
    STATUS_REGISTER_TERMINATION("940", "등록해지"),
    STATUS_ERROR_COUNT_EXCEEDED("960", "인증오류횟수 초과"),
    ;



    private final String code;
    private final String comment;

    KftcSecurityMediaStatus(String code, String comment) {
        this.code = code;
        this.comment = comment;
    }
}
