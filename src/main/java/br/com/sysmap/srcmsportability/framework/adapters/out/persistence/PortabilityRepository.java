package br.com.sysmap.srcmsportability.framework.adapters.out.persistence;

import br.com.sysmap.srcmsportability.domain.Portability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortabilityRepository extends JpaRepository<Portability, String> {
}
