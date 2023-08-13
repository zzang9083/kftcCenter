package com.project.kftcCenter.domain.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

// 은행
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank {
        private String hndlIcd; // 취급기관코드 10

        private String hndlInm; // 취급기관명 20

        public Bank(String hndlIcd, String hndlInm) {
                this.hndlIcd = hndlIcd;
                this.hndlInm = hndlInm;
        }


}
