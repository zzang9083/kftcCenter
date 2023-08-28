package com.project.kftcCenter.presentation.controller;

import com.project.kftcCenter.application.OtpAuthService;
import com.project.kftcCenter.application.dto.OtpActivateStepFirstCommand;
import com.project.kftcCenter.application.dto.OtpActivateStepFirstInfo;
import com.project.kftcCenter.common.response.CommonResponse;
import com.project.kftcCenter.presentation.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kftc/otp/auth")
public class OtpAuthController {
    private final OtpAuthService otpAuthService;

    public OtpAuthController(OtpAuthService otpAuthService) {
        this.otpAuthService = otpAuthService;
    }

    @PostMapping("/s1")
    public OtpActivateStepFirstRspn activateOtpS1(@RequestBody OtpActivateStepFirstRqst otpActivateStepFirstRqst) {
        OtpActivateStepFirstInfo result = otpAuthService.activateOtpStepFirst(OtpActivateStepFirstCommand.from(otpActivateStepFirstRqst));

        OtpActivateStepFirstRspn repn = OtpActivateStepFirstRspn.of(otpActivateStepFirstRqst, result);

        return repn;
    }

    @PostMapping("/s2")
    public OtpActivateStepSecondRspn regOtp(@RequestBody OtpActivateStepSecondRqst otpActivateStepSecondRqst) {

    }

//    @PostMapping("/vrfy")
//    public OtpVrfyVrfcCdRspn regOtp(@RequestBody OtpVrfyVrfcCdRqst otpVrfyVrfcCdRqst) {
//
//    }

}
