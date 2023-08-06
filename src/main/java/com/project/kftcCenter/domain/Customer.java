package com.project.kftcCenter.domain;

import com.project.kftcCenter.presentation.dto.OtpRegReq;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "usis_no")
    private Long usisNo;       // 금결원 이용자 번호
    @OneToOne
    @JoinColumn(name = "hndl_icd")
    private Bank bank;          // 은행

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private LocalDate birtYmd;     // 생년월일

    private LocalDateTime rgsnTs;   // 등록일시

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<SecurityMedia> securityMedia;    // 보안매체

    @Transient
    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public Customer(String hndlIcd, String prfmNm, String bswrCqrcgNo, String cpn, LocalDate birtYmd, LocalDateTime rgsnTs, OtpCommInfo otpCommInfo) {
        this.bank.setHndlIcd(hndlIcd);
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;
        this.OtpCommInfo = otpCommInfo;
    }


    public static Customer ofCustomer(OtpRegReq otpRegReq) {
        return new Customer(otpRegReq.getOtpCommInfo().getHndlIcd(), otpRegReq.getPrfmNm(), otpRegReq.getBswrCqrcgNo(),
                otpRegReq.getCpn(), otpRegReq.getBirtYmd(), LocalDateTime.now(), otpRegReq.getOtpCommInfo());
    }


}
