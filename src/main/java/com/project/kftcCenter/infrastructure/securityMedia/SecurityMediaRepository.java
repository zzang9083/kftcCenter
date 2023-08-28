package com.project.kftcCenter.infrastructure.securityMedia;

import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityMediaRepository extends JpaRepository<KftcSecurityMedia, Long> {
}
