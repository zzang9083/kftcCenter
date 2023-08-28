package com.project.kftcCenter.application.dto;

import com.project.kftcCenter.domain.common.OtpCommInfo;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMedia;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;
import lombok.Getter;

@Getter
public class OtpActivateStepFirstInfo {

    private long trnCode;         // 거래코드

    private String otpStateCode; // otp상태코드

    private int authErrCnt;      // 인증오류횟수

    private OtpCommInfo otpCommInfo; // 전문 공통부

    public OtpActivateStepFirstInfo(OtpCommInfo otpCommInfo, KftcSecurityMediaHistory newHistory, KftcSecurityMedia usedOtp) {
        this.otpCommInfo = otpCommInfo;
        this.trnCode = newHistory.getTrnCode();
        this.otpStateCode = usedOtp.getSccdScd().getCode();
        this.authErrCnt = usedOtp.getAuthErrCnt();
    }
}
