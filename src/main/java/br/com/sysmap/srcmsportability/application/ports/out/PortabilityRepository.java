package br.com.sysmap.srcmsportability.application.ports.out;

import br.com.sysmap.srcmsportability.domain.Portability;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PortabilityRepository {
    Portability save(Portability portability);
    List<Portability> findAll(UUID userId);
    Optional<Portability> findById(UUID portabilityId);
}
