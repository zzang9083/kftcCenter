package com.project.kftcCenter.application.dto;

import com.project.kftcCenter.domain.securityMedia.model.KftcToken;
import com.project.kftcCenter.domain.user.model.KftcUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TokenDTO {

    private Long usisNo; // 금결원 이용자 번호
    private String tknNo; // 토큰번호 400

    private LocalDateTime isncTs; // 발급시간

    private LocalDateTime expyTs; // 만료시간

    public TokenDTO(Long usisNo, String tknNo, LocalDateTime isncTs, LocalDateTime expyTs) {
        this.usisNo = usisNo;
        this.tknNo = tknNo;
        this.isncTs = isncTs;
        this.expyTs = expyTs;
    }

    public static TokenDTO from(KftcUser newUser, KftcToken kftcToken) {
        return new TokenDTO(newUser.getUsisNo(), kftcToken.getTknNo(), kftcToken.getIsncTs(), kftcToken.getExpyTs());
    }


}
