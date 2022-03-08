package br.com.sysmap.srcmsportability.application.services;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;

public class PortabilityServiceImpl implements PortabilityService {

    private final PortabilityRepository portabilityRepository;

    public PortabilityServiceImpl(PortabilityRepository portabilityRepository){
        this.portabilityRepository = portabilityRepository;
    }

    @Override
    public Portability newPortability(InputPortability portability) {
        return null;
    }

    @Override
    public Portability putPortability(PortabilityStatus portabilityStatus) {
        return null;
    }
}
