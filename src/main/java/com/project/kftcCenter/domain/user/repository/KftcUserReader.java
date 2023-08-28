package com.project.kftcCenter.domain.user.repository;

import com.project.kftcCenter.domain.user.model.KftcUser;

public interface KftcUserReader {

    public KftcUser findUserByBswrCqrcgNo(String rnn);
}
