package com.project.kftcCenter.domain.securityMedia.model;

import com.project.kftcCenter.domain.user.model.KftcUser;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KftcSecurityMedia {

    @Id
    @GeneratedValue
    @Column(name = "secu_no")
    private Long secuNo;       // 보안매체 번호(pk)

    @Column(name = "secu_cdn")
    private Long secuCdn; // 보안매체 일련번호

    @Enumerated(EnumType.STRING)
    private KftcSecurityMediaType secuType; //보안매체구분

    @Enumerated(EnumType.STRING)
    private KftcSecurityMediaStatus sccdScd; // 보안매체 상태코드


    private int authErrCnt; //인증오류횟수

    private LocalDate isncYmd; // 발급년월일

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "usis_no")
    private KftcUser user;      // 고객id(fk)


    @OneToMany(mappedBy = "kftcSecurityMedia", fetch = LAZY)
    private List<KftcToken> kftcToken = new ArrayList<>();    // 토큰

    @OneToMany(mappedBy = "kftcSecurityMedia") // 보안매체 이력
    private List<KftcSecurityMediaHistory> kftcSecurityMediaHistoryList = new ArrayList<>();

    public KftcSecurityMedia(KftcUser kftcUser, Long secuCdn, KftcSecurityMediaType type, KftcSecurityMediaStatus status) {
        this.secuCdn = secuCdn;
        this.secuType = type;
        this.sccdScd  = status;
        this.isncYmd = LocalDate.now();
        this.sysLsmdTs = LocalDateTime.now();
        this.user = kftcUser;
        user.getKftcSecurityMedia().add(this);
    }

    public static KftcSecurityMedia of(KftcUser kftcUser, Long secuCdn, KftcSecurityMediaType type, KftcSecurityMediaStatus status) {
        return new KftcSecurityMedia(kftcUser, secuCdn, type, status);

    }
    public void setToken(KftcToken newKftcToken) {
        this.getKftcToken().add(newKftcToken);
        newKftcToken.setKftcSecurityMedia(this);
    }

    public boolean isNomalStatus() {
        if(sccdScd.getCode() == "000")
            return true;
        else {
            return false;
        }
    }
}
