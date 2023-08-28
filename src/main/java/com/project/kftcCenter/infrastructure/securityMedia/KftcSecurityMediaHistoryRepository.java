package com.project.kftcCenter.infrastructure.securityMedia;

import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KftcSecurityMediaHistoryRepository extends JpaRepository<KftcSecurityMediaHistory, Long> {
}
