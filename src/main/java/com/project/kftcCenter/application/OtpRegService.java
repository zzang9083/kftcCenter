package com.project.kftcCenter.application;

import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.Customer;
import com.project.kftcCenter.domain.SecurityMedia;
import com.project.kftcCenter.domain.Token;
import com.project.kftcCenter.repository.CustomerRepository;
import com.project.kftcCenter.repository.SecurityMediaRepository;
import com.project.kftcCenter.application.funtion.TokenUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OtpRegService {

    private final TokenUtil tokenUtil;
    private final CustomerRepository customerRepository;

    private final SecurityMediaRepository securityMediaRepository;

    public OtpRegService(TokenUtil tokenUtil, CustomerRepository customerRepository,
                         SecurityMediaRepository securityMediaRepository) {
        this.tokenUtil = tokenUtil;
        this.customerRepository = customerRepository;
        this.securityMediaRepository= securityMediaRepository;
    }

    public TokenDTO reqOtpRegReq(Customer customer) {

        SecurityMedia otp = null;
        //고객 등록
        Customer newCust = customerRepository.save(customer);
        //otp 생성
        SecurityMedia newOtp = securityMediaRepository.saveAndFlush(new SecurityMedia(customer));
        //토큰 생성
        String tokenId = tokenUtil.createToken(newOtp.getSecuCdn());
        Token newToken = new Token(TokenUtil.getClaimsByToken(tokenId));

        newOtp.getToken().add(newToken);
        otp = securityMediaRepository.save(newOtp);

        //이력 생성

        return TokenDTO.from(newToken);
    }

}
