package com.project.kftcCenter.application.dto;

import com.project.kftcCenter.domain.Token;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TokenDTO {

    private String tknNo; // 토큰번호 400

    public TokenDTO(String tknNo) {
        this.tknNo = tknNo;
    }

    public static TokenDTO from(Token token) {
        return new TokenDTO(token.getTknNo());
    }


}
