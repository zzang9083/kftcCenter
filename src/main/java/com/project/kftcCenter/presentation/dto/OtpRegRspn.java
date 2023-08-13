package com.project.kftcCenter.presentation.dto;

import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.model.OtpCommInfo;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class OtpRegRspn {

    private String usisNo;      //금결원 이용자 번호
    private String prfmNm;               // 전문성명

    private String bswrCqrcgNo;         // 업무고유식별번호

    private String cpn;                 // 휴대번호

    private LocalDate birtYmd;          // 생년월일

    private LocalDateTime rgsnTs;       // 등록일시

    private Long secuCdn;       // 보안매체 일련번호

    private String tknNo;             // 토큰번호

    private LocalDateTime tknIsncTs; // 발급시간

    private LocalDateTime tknExpyTs; // 만료시간

    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public OtpRegRspn(String prfmNm, String bswrCqrcgNo, String cpn, LocalDate birtYmd, LocalDateTime rgsnTs, String tokenNo, com.project.kftcCenter.domain.model.OtpCommInfo otpCommInfo) {
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;
        this.tknNo = tokenNo;
        OtpCommInfo = otpCommInfo;
    }

    public static OtpRegRspn of(TokenDTO tokenDto, OtpRegReq otpRegReq) {
        return new OtpRegRspn(otpRegReq.getPrfmNm(),otpRegReq.getBswrCqrcgNo(), otpRegReq.getCpn(),
                otpRegReq.getBirtYmd(),otpRegReq.getRgsnTs(), tokenDto.getTknNo(), otpRegReq.getOtpCommInfo());
    }
}
