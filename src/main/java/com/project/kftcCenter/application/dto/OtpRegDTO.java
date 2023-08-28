package com.project.kftcCenter.application.dto;

import com.project.kftcCenter.domain.common.OtpCommInfo;
import com.project.kftcCenter.presentation.dto.OtpRegReq;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class OtpRegDTO {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private Long secuCdn;       // 보안매체 일련번호

    private String cpn;         // 휴대번호

    private LocalDate birtYmd;     // 생년월일

    private LocalDateTime rgsnTs;      // 등록일시

    private OtpCommInfo otpCommInfo; // 거래 공통부

    public OtpRegDTO(String prfmNm, String bswrCqrcgNo, Long secuCdn, String cpn, LocalDate birtYmd, LocalDateTime rgsnTs, OtpCommInfo otpCommInfo) {
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.secuCdn = secuCdn;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;
        this.otpCommInfo = otpCommInfo;
    }

    public static OtpRegDTO from(OtpRegReq otpRegReq) {
        return new OtpRegDTO(
                otpRegReq.getPrfmNm(),
                otpRegReq.getBswrCqrcgNo(),
                otpRegReq.getSecuCdn(),
                otpRegReq.getCpn(),
                otpRegReq.getBirtYmd(),
                otpRegReq.getRgsnTs(),
                otpRegReq.getOtpCommInfo());

    }
}
