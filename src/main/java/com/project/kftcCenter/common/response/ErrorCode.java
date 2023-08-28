package com.project.kftcCenter.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum ErrorCode {
//    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
//    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
//    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
//    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다."),

    // 일반업무전용
    NOT_EXIST_OTP_ERROR("3090","존재하지 않는 디지털 OTP 일련번호"),

    // 인증전용
    AUTH_OTP_STATUS_ERROR("6010","디지털OTP 상태오류(디지털OTP 상태코드 확인)"),
    ;
//    GIFT_NOT_MODIFY_DELIVERY_CONDITION("배송지 변경이 가능한 상태가 아닙니다.");

    private final String errorCode;
    private final String errorMsg;

    ErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
