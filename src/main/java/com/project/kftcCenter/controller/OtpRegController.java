package com.project.kftcCenter.controller;

import com.project.kftcCenter.controller.dto.OtpRegReq;
import com.project.kftcCenter.domain.Customer;
import com.project.kftcCenter.domain.SecurityMedia;
import com.project.kftcCenter.service.OtpRegService;
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
    public void regOtp(@RequestBody OtpRegReq otpRegReq) {
        // otp 등록
        SecurityMedia securityMedia = otpRegService.reqOtpRegReq(Customer.ofCustomer(otpRegReq));

        return ;

    }


}
