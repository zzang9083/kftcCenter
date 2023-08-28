package com.project.kftcCenter.infrastructure.securityMedia;

import com.project.kftcCenter.domain.securityMedia.model.KftcSecurityMediaHistory;
import com.project.kftcCenter.domain.securityMedia.repository.KftcSecurityMediaHistoryStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class KftcSecurityMediaHistoryStoreImpl implements KftcSecurityMediaHistoryStore {

    private final KftcSecurityMediaHistoryRepository historyRepository;

    @Override
    public KftcSecurityMediaHistory store(KftcSecurityMediaHistory history) {
        return historyRepository.save(history);
    }
}
