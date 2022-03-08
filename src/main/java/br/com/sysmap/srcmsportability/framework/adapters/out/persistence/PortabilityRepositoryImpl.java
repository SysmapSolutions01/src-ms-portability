package br.com.sysmap.srcmsportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Portability;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PortabilityRepositoryImpl implements PortabilityRepository {

    private final PortabilityRepositoryJpa portabilityRepositoryJpa;


    @Override
    public Portability save(Portability portability) {
        return portabilityRepositoryJpa.save(portability);
    }

    @Override
    public Optional<Portability> findById(UUID portabilityId) {
        return portabilityRepositoryJpa.findById(portabilityId.toString());
    }
}
