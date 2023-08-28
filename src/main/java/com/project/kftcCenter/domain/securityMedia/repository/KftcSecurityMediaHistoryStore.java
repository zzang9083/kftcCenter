package com.project.kftcCenter.domain.securityMedia.repository;

import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;

public interface KftcSecurityMediaHistoryStore {

    KftcSecurityMediaHistory store(KftcSecurityMediaHistory history);
}
