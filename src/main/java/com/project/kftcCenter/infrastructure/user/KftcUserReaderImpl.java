package com.project.kftcCenter.infrastructure.user;

import com.project.kftcCenter.domain.user.model.KftcUser;
import com.project.kftcCenter.domain.user.repository.KftcUserReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class KftcUserReaderImpl implements KftcUserReader {

    private final KftcUserRepository kftcUserRepository;

    @Override
    public KftcUser findUserByBswrCqrcgNo(String rnn) {
        return kftcUserRepository.findOptionalCustomerByBswrCqrcgNo(rnn)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));

    }
}
