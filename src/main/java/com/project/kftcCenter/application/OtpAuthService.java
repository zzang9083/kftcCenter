package com.project.kftcCenter.application;

import com.project.kftcCenter.application.dto.OtpActivateStepFirstCommand;
import com.project.kftcCenter.application.dto.OtpActivateStepFirstInfo;
import com.project.kftcCenter.common.exception.BusinessException;
import com.project.kftcCenter.common.response.ErrorCode;
import com.project.kftcCenter.domain.common.OtpCommInfo;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMedia;
import com.project.kftcCenter.domain.securityMedia.repository.KftcSecurityMediaHistoryStore;
import com.project.kftcCenter.domain.user.model.KftcUser;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaType;
import com.project.kftcCenter.domain.user.repository.KftcUserReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class OtpAuthService {

    private final KftcUserReader kftcUserReader;

    private final KftcSecurityMediaHistoryStore historyStore;

    public OtpAuthService(KftcUserReader kftcUserReader, KftcSecurityMediaHistoryStore historyStore) {
        this.kftcUserReader = kftcUserReader;
        this.historyStore = historyStore;
    }

    @Transactional
    public OtpActivateStepFirstInfo activateOtpStepFirst(OtpActivateStepFirstCommand inDTO) {

        OtpCommInfo outCommInfo = new OtpCommInfo(inDTO.getOtpCommInfo());
        KftcSecurityMedia usedOtp = null;
        KftcSecurityMediaHistory newHistory = null;

        // 요청고객 찾기
        KftcUser findUser = kftcUserReader.findUserByBswrCqrcgNo(inDTO.getRnn());

        // 디지털 otp FIND
        try {
            usedOtp = findUser.getActiveSecurityMedia(inDTO.getSecuCdn(), KftcSecurityMediaType.DIGITAL_OTP);
        } catch (BusinessException e) {
            outCommInfo.setFnbbRpcdNo(e.getErrorCode().getErrorCode());
        }
        // 거래이력 생성
        if(usedOtp.isNomalStatus()) {
            newHistory = inDTO.toEntity(inDTO, usedOtp);
            historyStore.store(newHistory);
        }

        return new OtpActivateStepFirstInfo(outCommInfo, newHistory, usedOtp);
    }
}
