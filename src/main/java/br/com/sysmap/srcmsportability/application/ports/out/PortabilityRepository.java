package br.com.sysmap.srcmsportability.application.ports.out;

import br.com.sysmap.srcmsportability.domain.Portability;
import java.util.Optional;
import java.util.UUID;

public interface PortabilityRepository {
    Portability save(Portability portability);
    Optional<Portability> findById(UUID portabilityId);
}
