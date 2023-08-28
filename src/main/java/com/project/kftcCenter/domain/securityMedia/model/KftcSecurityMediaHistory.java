package com.project.kftcCenter.domain.securityMedia.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KftcSecurityMediaHistory {

    @Id
    @GeneratedValue
    private long trnCode;         // 거래코드

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "secu_no")   // 보안매체 일련번호
    private KftcSecurityMedia kftcSecurityMedia;

    private LocalDate trnYmd; // 거래년월일

    private LocalDateTime trnAt; // 거래시각

    private LocalDateTime expyAt; // 만료시각

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private String trnContent; // 거래내역


    public KftcSecurityMediaHistory(KftcSecurityMedia usedOtp, String usageCd, String trnContent) {
        setKftcSecurityMedia(usedOtp);
        this.trnYmd = LocalDate.now();
        this.expyAt = trnAt.plusMinutes(10); // 거래 만료시간: 10분 후
        this.trnAt = LocalDateTime.now();
        this.usageCd = usageCd;
        this.trnContent = trnContent;
    }

    private void setKftcSecurityMedia(KftcSecurityMedia usedOtp) {
        this.kftcSecurityMedia = usedOtp;
        usedOtp.getKftcSecurityMediaHistoryList().add(this);
    }
}
