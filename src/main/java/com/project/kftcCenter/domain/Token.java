package com.project.kftcCenter.domain;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {

    @Id
    private String tknNo; // 토큰번호 400

    private LocalDateTime isncTs; // 발급시간

    private LocalDateTime expyTs; // 만료시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "secu_cdn")
    private SecurityMedia securityMedia;   // 보안매체

    public Token(Claims claims) {
        this.tknNo = claims.getId();
        this.isncTs = LocalDateTime.ofInstant(claims.getIssuedAt().toInstant(), ZoneId.systemDefault());
        this.expyTs = LocalDateTime.ofInstant(claims.getExpiration().toInstant(), ZoneId.systemDefault());
        this.sysLsmdTs = LocalDateTime.now();
    }

}
