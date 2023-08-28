package com.project.kftcCenter.infrastructure.user;

import com.project.kftcCenter.domain.user.model.KftcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KftcUserRepository extends JpaRepository<KftcUser, Long> {
    Optional<KftcUser> findOptionalCustomerByBswrCqrcgNo(String bswrCqrcgNo);


}
