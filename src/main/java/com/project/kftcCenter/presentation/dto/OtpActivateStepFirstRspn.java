package com.project.kftcCenter.presentation.dto;

import com.project.kftcCenter.application.dto.OtpActivateStepFirstInfo;
import com.project.kftcCenter.domain.common.OtpCommInfo;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OtpActivateStepFirstRspn {

    private long trnCode;         // 거래코드

    private String otpStateCode; // otp상태코드

    private int authErrCnt;      // 인증오류횟수

    private String custName;    // 고객명

    private String rnn; // 실명번호(사업자번호)

    private String cpn;     // 핸드폰번호

    private LocalDate birtYmd; // 생년월일

    private Long secuCdn; // 보안매체 일련번호

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private String trnContent; // 거래내역



    private OtpCommInfo otpCommInfo; // 거래 공통부


    public OtpActivateStepFirstRspn(String custName, String rnn, String cpn, LocalDate birtYmd, Long secuCdn, String usageCd, String trnContent, long trnCode, String otpStateCode, int authErrCnt, OtpCommInfo otpCommInfo) {
        this.custName = custName;
        this.rnn = rnn;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.secuCdn = secuCdn;
        this.usageCd = usageCd;
        this.trnContent = trnContent;
        this.trnCode = trnCode;
        this.otpStateCode = otpStateCode;
        this.authErrCnt = authErrCnt;
        this.otpCommInfo = otpCommInfo;
    }

    public static OtpActivateStepFirstRspn of(OtpActivateStepFirstRqst req, OtpActivateStepFirstInfo result) {

        return new OtpActivateStepFirstRspn(req.getCustName(), req.getRnn(), req.getCpn(), req.getBirtYmd(),
                req.getSecuCdn(),req.getUsageCd(), req.getTrnContent(), result.getTrnCode(),result.getOtpStateCode(),result.getAuthErrCnt(), result.getOtpCommInfo());



    }
}
