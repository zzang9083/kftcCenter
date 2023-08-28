package com.project.kftcCenter.common.exception;

import com.project.kftcCenter.common.response.ErrorCode;

public class BusinessException extends RuntimeException{

    private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
