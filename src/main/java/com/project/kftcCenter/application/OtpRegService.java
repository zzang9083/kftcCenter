package com.project.kftcCenter.application;

import com.project.kftcCenter.application.dto.OtpRegDTO;
import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMedia;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaStatus;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaType;
import com.project.kftcCenter.domain.securityMedia.model.KftcToken;
import com.project.kftcCenter.domain.user.model.KftcUser;
import com.project.kftcCenter.infrastructure.securityMedia.KftcTokenRepository;
import com.project.kftcCenter.infrastructure.user.KftcUserRepository;
import com.project.kftcCenter.infrastructure.securityMedia.SecurityMediaRepository;
import com.project.kftcCenter.application.funtion.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
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

    @Transactional
    public TokenDTO reqOtpRegReq(OtpRegDTO otpRegDTO) {

        //고객 등록
        KftcUser newUser = kftcUserRepository.save(KftcUser.from(otpRegDTO));

        log.info("*** getUsisNo: {}",newUser.getUsisNo());

        //otp 생성
        KftcSecurityMedia newOtp = securityMediaRepository.save(
                KftcSecurityMedia.of(newUser, otpRegDTO.getSecuCdn(), KftcSecurityMediaType.DIGITAL_OTP, KftcSecurityMediaStatus.STATUS_REGISTER));

        log.info("*** newOtp: {}",newOtp.getSecuCdn());

        //토큰 생성
        String tokenId = tokenUtil.createToken(newOtp.getSecuCdn());
        log.info("*** tokenId input: {}", tokenId);

        KftcToken newKftcToken = kftcTokenRepository.save(KftcToken.of(tokenId, TokenUtil.getClaimsByToken(tokenId), newOtp));

        newOtp.setToken(newKftcToken);

        log.info("*** tokenId: {}", tokenId);

        //이력 생성

        return TokenDTO.from(newUser, newKftcToken);
    }

}
