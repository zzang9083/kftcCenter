package com.project.kftcCenter.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KftcSecurityMediaHistory {

    @Id
    @GeneratedValue
    private long trnSrn;            // 거래일련번호

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "secuCdn")   // 보안매체 일련번호
    private KftcSecurityMedia kftcSecurityMedia;


    private LocalDate trnYmd; // 거래년월일
}
