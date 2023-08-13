package com.project.kftcCenter.domain.model;

import com.project.kftcCenter.application.dto.OtpRegDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KftcUser {

    @Id
    @GeneratedValue
    @Column(name = "usis_no")
    private Long usisNo;       // 금결원 이용자 번호
    @Embedded
    private Bank bank;    // 은행

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private LocalDate birtYmd;     // 생년월일

    private LocalDateTime rgsnTs;   // 등록일시

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private List<KftcSecurityMedia> kftcSecurityMedia;    // 보안매체

//    @Transient
//    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public KftcUser(String hndlIcd, String prfmNm, String bswrCqrcgNo, String cpn, LocalDate birtYmd, LocalDateTime rgsnTs) {
        this.bank = new Bank (hndlIcd, "기업은행");
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;

        kftcSecurityMedia = new ArrayList<>();
//        this.OtpCommInfo = otpCommInfo;

    }

    public static KftcUser from(OtpRegDTO otpRegDTO) {
        return new KftcUser(
                otpRegDTO.getOtpCommInfo().getHndlIcd(),
                otpRegDTO.getPrfmNm(),
                otpRegDTO.getBswrCqrcgNo(),
                otpRegDTO.getCpn(),
                otpRegDTO.getBirtYmd(),
                otpRegDTO.getRgsnTs()
        );
    }





}
