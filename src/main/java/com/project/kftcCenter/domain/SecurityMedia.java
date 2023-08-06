package com.project.kftcCenter.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecurityMedia {

    @Id
    @Column(name = "secu_cdn")
    private Long secuCdn; // 보안매체 일련번호

    @Enumerated(EnumType.STRING)
    private SecurityMediaType secuType; //보안매체구분

    @Enumerated(EnumType.STRING)
    private SecurityMediaStatus sccdScd; // 보안매체 상태코드

    private LocalDate isncYmd; // 발급년월일

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;      // 고객id(fk)


    @OneToMany(mappedBy = "securityMedia", fetch = LAZY)
    private List<Token> token;    // 토큰

    @OneToMany(mappedBy = "securityMedia") // 보안매체 이력
    private List<SecurityMediaHistory> securityMediaHistoryList = new ArrayList<>();


    public SecurityMedia(Customer customer) {
        this.secuType = SecurityMediaType.DIGITAL_OTP;
        this.sccdScd  = SecurityMediaStatus.REGISTION_WAIT;
        this.isncYmd = LocalDate.now();
        this.sysLsmdTs = LocalDateTime.now();
        this.customer  = customer;
        customer.getSecurityMedia().add(this);
    }


}
