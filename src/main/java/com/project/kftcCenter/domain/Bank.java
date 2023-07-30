package com.project.kftcCenter.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 대외거래이력
@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank {

        @Id
        @Column(name = "hndl_icd")
        private String hndlIcd; // 취급기관코드 10

        private String hndlInm; // 취급기관명 20
}
