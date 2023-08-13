package com.project.kftcCenter.application;

import com.project.kftcCenter.application.dto.OtpRegDTO;
import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.model.*;
import com.project.kftcCenter.repository.KftcTokenRepository;
import com.project.kftcCenter.repository.KftcUserRepository;
import com.project.kftcCenter.repository.SecurityMediaRepository;
import com.project.kftcCenter.application.funtion.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
public class OtpRegService {

    private final TokenUtil tokenUtil;
    private final KftcUserRepository kftcUserRepository;
    private final SecurityMediaRepository securityMediaRepository;

    private final KftcTokenRepository kftcTokenRepository;

    public OtpRegService(TokenUtil tokenUtil, KftcUserRepository kftcUserRepository,
                         SecurityMediaRepository securityMediaRepository, KftcTokenRepository kftcTokenRepository) {
        this.tokenUtil = tokenUtil;
        this.kftcUserRepository = kftcUserRepository;
        this.securityMediaRepository= securityMediaRepository;
        this.kftcTokenRepository = kftcTokenRepository;
    }

    public TokenDTO reqOtpRegReq(OtpRegDTO otpRegDTO) {

        //고객 등록
        KftcUser newCust = kftcUserRepository.save(KftcUser.from(otpRegDTO));

        log.info("*** getUsisNo: {}",newCust.getUsisNo());

        //otp 생성
        KftcSecurityMedia newOtp = securityMediaRepository.save(
                KftcSecurityMedia.of(newCust, otpRegDTO.getSecuCdn(), KftcSecurityMediaType.DIGITAL_OTP, KftcSecurityMediaStatus.REGISTION));

        log.info("*** newOtp: {}",newOtp.getSecuCdn());

        //토큰 생성
        String tokenId = tokenUtil.createToken(newOtp.getSecuCdn());
        log.info("*** tokenId input: {}", tokenId);

        KftcToken newKftcToken = kftcTokenRepository.save(KftcToken.of(tokenId, TokenUtil.getClaimsByToken(tokenId), newOtp));

        log.info("*** tokenId: {}", tokenId);

        //이력 생성

        return TokenDTO.from(newKftcToken);
    }

}
