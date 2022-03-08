package br.com.sysmap.srcmsportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Portability;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PortabilityRepositoryImpl implements PortabilityRepository {

    private final PortabilityRepositoryJpa portabilityRepositoryJpa;


    @Override
    public Portability save(Portability portability) {
        return null;
    }

    @Override
    public List<Portability> findAll(UUID userId) {
        return null;
    }

    @Override
    public Optional<Portability> findById(UUID portabilityId) {
        return Optional.empty();
    }
}
