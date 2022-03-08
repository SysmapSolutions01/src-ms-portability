package br.com.sysmap.srcmsportability.application.ports.in;

import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;

public interface PortabilityService {
    Portability newPortability(InputPortability portability);
}
