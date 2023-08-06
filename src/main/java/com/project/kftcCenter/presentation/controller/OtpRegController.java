package com.project.kftcCenter.presentation.controller;

import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.OtpCommInfo;
import com.project.kftcCenter.presentation.dto.OtpRegReq;
import com.project.kftcCenter.domain.Customer;
import com.project.kftcCenter.domain.SecurityMedia;
import com.project.kftcCenter.application.OtpRegService;
import com.project.kftcCenter.presentation.dto.OtpRegRspn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kftc/otp")
public class OtpRegController {

    private final OtpRegService otpRegService;

    public OtpRegController(OtpRegService otpRegService) {
        this.otpRegService = otpRegService;
    }

    @PostMapping("/register")
    public OtpRegRspn regOtp(@RequestBody OtpRegReq otpRegReq) {

        OtpCommInfo returnOtpComm = otpRegReq.getOtpCommInfo();
        boolean success = true;
        TokenDTO token = null;

        try {
            // otp 등록
            token = otpRegService.reqOtpRegReq(Customer.ofCustomer(otpRegReq));
            otpRegService.reqOtpRegReq(Customer.ofCustomer(otpRegReq));
        } catch (Exception e) {

        } finally {
            if (success) {
                returnOtpComm.setFnbbRpcdNo("0000");
            }
        }
        return OtpRegRspn.of(token, otpRegReq);

    }


}
