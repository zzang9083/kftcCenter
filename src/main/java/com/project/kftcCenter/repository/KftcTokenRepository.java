package com.project.kftcCenter.repository;

import com.project.kftcCenter.domain.model.KftcToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KftcTokenRepository extends JpaRepository<KftcToken, String> {
}
