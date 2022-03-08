package br.com.sysmap.srcmsportability.application.ports.in;

import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.UpdatePortabilityStatusDTO;

import java.util.UUID;

public interface PortabilityService {
    Portability newPortability(InputPortability portability);
    void putPortability(UUID id, UpdatePortabilityStatusDTO portabilityStatus);
}
