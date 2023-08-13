package com.project.kftcCenter.presentation.dto;

import com.project.kftcCenter.domain.model.OtpCommInfo;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class OtpRegReq {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private Long secuCdn;       // 보안매체 일련번호

    private String cpn;         // 휴대번호

    private LocalDate birtYmd;     // 생년월일

    private LocalDateTime rgsnTs;      // 등록일시

    private OtpCommInfo otpCommInfo; // 거래 공통부
}
