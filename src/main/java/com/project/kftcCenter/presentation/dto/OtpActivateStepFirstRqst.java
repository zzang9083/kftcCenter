package com.project.kftcCenter.presentation.dto;

import com.project.kftcCenter.domain.common.OtpCommInfo;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OtpActivateStepFirstRqst {

    private String custName;    // 고객명

    private String rnn; // 실명번호(사업자번호)

    private String cpn;     // 핸드폰번호

    private LocalDate birtYmd; // 생년월일

    private Long secuCdn; // 보안매체 일련번호

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private String trnContent; // 거래내역

    private OtpCommInfo otpCommInfo; // 거래 공통부
}
