package br.com.sysmap.srcmsportability.application.services;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;

import java.util.Optional;
import java.util.UUID;

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
    public void putPortability(UUID id,PortabilityStatus portabilityStatus) {
        Optional<Portability> entity = portabilityRepository.findById(id);
        entity.get().setPortabilityStatus(portabilityStatus);
        portabilityRepository.save(entity.get());
    }
}
