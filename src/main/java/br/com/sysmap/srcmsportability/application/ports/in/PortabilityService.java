package br.com.sysmap.srcmsportability.application.ports.in;

import br.com.sysmap.srcmsportability.domain.Portability;

public interface PortabilityService {
    Portability newPortability(Portability portability);
}
