package com.project.kftcCenter.presentation.controller;

import com.project.kftcCenter.application.dto.OtpRegDTO;
import com.project.kftcCenter.application.dto.TokenDTO;
import com.project.kftcCenter.domain.common.OtpCommInfo;
import com.project.kftcCenter.presentation.dto.OtpRegReq;
import com.project.kftcCenter.application.OtpRegService;
import com.project.kftcCenter.presentation.dto.OtpRegRspn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/kftc/otp")
public class OtpRegController {

    private final OtpRegService otpRegService;

    public OtpRegController(OtpRegService otpRegService) {
        this.otpRegService = otpRegService;
    }

    @PostMapping("/register")
    public OtpRegRspn regOtp(@RequestBody OtpRegReq otpRegReq) {

        log.info("**** OtpRegReq.getBswrCqrcgNo:{}", otpRegReq.getBswrCqrcgNo());
        log.info("**** OtpRegReq.getHndlIcd:{}", otpRegReq.getOtpCommInfo().getTrnTlgrSrn());
        log.info("**** OtpRegReq.getPrfmNm:{}", otpRegReq.getPrfmNm());
        log.info("**** OtpRegReq.getCpn:{}", otpRegReq.getCpn());


        OtpCommInfo returnOtpComm = otpRegReq.getOtpCommInfo();
        boolean success = true;
        TokenDTO tokenDTO = null;

        try {
            log.info("*****before");
            // otp 등록
            tokenDTO = otpRegService.reqOtpRegReq(OtpRegDTO.from(otpRegReq));
        } catch (Exception e) {
            log.info("*****catch: {}",e);
        } finally {
            if (success) {
                //returnOtpComm.setFnbbRpcdNo("0000");
            }
        }
        return OtpRegRspn.of(tokenDTO, otpRegReq, "A0000");

    }


}
