package com.project.kftcCenter.repository;

import com.project.kftcCenter.domain.model.KftcSecurityMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityMediaRepository extends JpaRepository<KftcSecurityMedia, Long> {
}
