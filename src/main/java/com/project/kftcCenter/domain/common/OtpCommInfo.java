package com.project.kftcCenter.domain.common;

import lombok.*;

@Getter
public class OtpCommInfo {

    private String extTrnBswrDcd; // 대외거래업무구분코드 4

    private String tlgrIttcd; // 전문종별코드 4

    private String extTrnDcd; // 대외거래구분코드 10

    private String hndlIcd; // 취급기관코드 10

    private String fnbbRpcdNo; // 공동망응답코드번호 4

    private String trnTlgrSrn; // 거래전문일련번호 8

    private String tlsdHms; // 전문송신시각 6

    public void setFnbbRpcdNo(String fnbbRpcdNo) {
        this.fnbbRpcdNo = fnbbRpcdNo;
    }

    @Builder
    public OtpCommInfo(String extTrnBswrDcd, String tlgrIttcd, String extTrnDcd, String hndlIcd
                        , String fnbbRpcdNo, String trnTlgrSrn, String tlsdHms) {
        this.extTrnBswrDcd = extTrnBswrDcd;
        this.tlgrIttcd = tlgrIttcd;
        this.extTrnDcd = extTrnDcd;
        this.hndlIcd = hndlIcd;
        this.fnbbRpcdNo = fnbbRpcdNo;
        this.trnTlgrSrn = trnTlgrSrn;
        this.tlsdHms    = tlsdHms;
    }

    public OtpCommInfo(OtpCommInfo oldOtpCommInfo) {
        this.extTrnBswrDcd = oldOtpCommInfo.getExtTrnBswrDcd();
        this.tlgrIttcd = oldOtpCommInfo.getTlgrIttcd();
        this.extTrnDcd = oldOtpCommInfo.getExtTrnDcd();
        this.hndlIcd = oldOtpCommInfo.getHndlIcd();
        this.fnbbRpcdNo = oldOtpCommInfo.getFnbbRpcdNo();
        this.trnTlgrSrn = oldOtpCommInfo.getTrnTlgrSrn();
        this.tlsdHms    = oldOtpCommInfo.getTlsdHms();
    }

}
