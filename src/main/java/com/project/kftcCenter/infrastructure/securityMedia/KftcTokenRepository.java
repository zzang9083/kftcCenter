package com.project.kftcCenter.infrastructure.securityMedia;

import com.project.kftcCenter.domain.securityMedia.model.KftcToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KftcTokenRepository extends JpaRepository<KftcToken, String> {
}
