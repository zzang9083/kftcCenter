package com.project.kftcCenter.domain.securityMedia.model;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class KftcToken {

    @Id
    private String tknNo; // 토큰번호 400

    private LocalDateTime isncTs; // 발급시간

    private LocalDateTime expyTs; // 만료시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "secu_cdn")
    private KftcSecurityMedia kftcSecurityMedia;   // 보안매체

    public KftcToken(String tknNo, LocalDateTime isncTs, LocalDateTime expyTs, KftcSecurityMedia newOtp) {
        this.tknNo = tknNo;
        this.isncTs = isncTs;
        this.expyTs = expyTs;
        this.sysLsmdTs = LocalDateTime.now();
        this.kftcSecurityMedia = newOtp;
        newOtp.getKftcToken().add(this);
    }

    public static KftcToken of(String tokenId, Claims claims, KftcSecurityMedia newOtp) {

        return new KftcToken(
                tokenId,
                LocalDateTime.ofInstant(claims.getIssuedAt().toInstant(), ZoneId.systemDefault()),
                LocalDateTime.ofInstant(claims.getExpiration().toInstant(), ZoneId.systemDefault()),
                newOtp
        );
    }
}
