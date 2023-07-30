package com.project.kftcCenter.service;

import com.project.kftcCenter.domain.Customer;
import com.project.kftcCenter.domain.SecurityMedia;
import com.project.kftcCenter.domain.Token;
import com.project.kftcCenter.repository.CustomerRepository;
import com.project.kftcCenter.repository.SecurityMediaRepository;
import com.project.kftcCenter.service.funtion.TokenUtil;
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

    public SecurityMedia reqOtpRegReq(Customer customer) {
        //고객 등록
        Customer newCust = customerRepository.saveAndFlush(customer);
        //otp 생성
        SecurityMedia newOtp = securityMediaRepository.saveAndFlush(new SecurityMedia(customer));
        //토큰 생성
        String tokenId = tokenUtil.createToken(newOtp.getSecuCdn());
        newOtp.setToken(new Token(TokenUtil.getClaimsByToken(tokenId)));
        SecurityMedia otp = securityMediaRepository.save(newOtp);

        return otp;
    }

}
