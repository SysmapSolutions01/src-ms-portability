package br.com.sysmap.srcmsportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmsportability.domain.Portability;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public class PortabilityRepositoryImpl implements JpaRepository<Portability, String> {

    private final PortabilityRepositoryJpa portabilityRepositoryJpa;


}
