package com.project.kftcCenter.repository;

import com.project.kftcCenter.domain.model.KftcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KftcUserRepository extends JpaRepository<KftcUser, Long> {
}
