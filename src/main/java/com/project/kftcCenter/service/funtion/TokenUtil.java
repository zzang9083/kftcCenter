package com.project.kftcCenter.service.funtion;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenUtil {

    @Value("${jwt.secretKey}")
    private static String secretKeyPlain; // plain 시크릿 키

    @Value("${jwt.expireTime}")
    private static long expireTime; // 만료시간

    private static String cachedSecretKey; // 시크릿 키를 담는 변수

    public TokenUtil() {
        this.cachedSecretKey = setSecretKey().toString(); // 암호화된 시크릿 키 저장
    }



    // 시크릿 키를 BASE64로
    private SecretKey setSecretKey() {
        String keyBase64Encoded = Base64.getEncoder().encodeToString(secretKeyPlain.getBytes());
        return Keys.hmacShaKeyFor(keyBase64Encoded.getBytes());
    }


    // 토큰 생성
    public String createToken(Long subject) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(cachedSecretKey.toString());

        Key signalkey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject.toString())
                .signWith(signalkey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() * expireTime))
                .compact();
    }

    // 토큰으로 Cliam 얻기
    public static Claims getClaimsByToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(cachedSecretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 토큰 검증 메서드
    public static boolean validationToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(cachedSecretKey))
                .build()
                .parseClaimsJws(token)
                .getBody();

        if(claims == null) return false;

        return true;
    }
}
