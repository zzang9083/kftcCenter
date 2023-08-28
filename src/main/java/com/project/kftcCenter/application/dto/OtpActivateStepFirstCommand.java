package com.project.kftcCenter.application.dto;

import com.project.kftcCenter.domain.common.OtpCommInfo;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMedia;
import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;
import com.project.kftcCenter.presentation.dto.OtpActivateStepFirstRqst;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OtpActivateStepFirstCommand {

    private String custName;    // 고객명

    private String rnn; // 실명번호(사업자번호)

    private String cpn;     // 핸드폰번호

    private LocalDate birtYmd; // 생년월일

    private Long secuCdn; // 보안매체 일련번호

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private String trnContent; // 거래내역

    private OtpCommInfo otpCommInfo; // 거래 공통부

    public OtpActivateStepFirstCommand(String custName, String rnn, String cpn, LocalDate birtYmd, Long secuCdn, String usageCd, String trnContent, OtpCommInfo otpCommInfo) {
        this.custName = custName;
        this.rnn = rnn;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.secuCdn = secuCdn;
        this.usageCd = usageCd;
        this.trnContent = trnContent;
        this.otpCommInfo = otpCommInfo;
    }

    public static OtpActivateStepFirstCommand from(OtpActivateStepFirstRqst otpActivateStepFirstRqst) {
        return new OtpActivateStepFirstCommand(
                otpActivateStepFirstRqst.getCustName(),
                otpActivateStepFirstRqst.getRnn(),
                otpActivateStepFirstRqst.getCpn(),
                otpActivateStepFirstRqst.getBirtYmd(),
                otpActivateStepFirstRqst.getSecuCdn(),
                otpActivateStepFirstRqst.getUsageCd(),
                otpActivateStepFirstRqst.getTrnContent(),
                otpActivateStepFirstRqst.getOtpCommInfo()
        );
    }

    public KftcSecurityMediaHistory toEntity(OtpActivateStepFirstCommand inDTO, KftcSecurityMedia usedOtp) {
        return new KftcSecurityMediaHistory(usedOtp, inDTO.getUsageCd(), inDTO.getTrnContent());
    }
}
