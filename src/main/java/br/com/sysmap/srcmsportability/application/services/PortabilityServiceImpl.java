package br.com.sysmap.srcmsportability.application.services;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.User;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.UpdatePortabilityStatusDTO;
import br.com.sysmap.srcmsportability.framework.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.UUID;

public class PortabilityServiceImpl implements PortabilityService {

    private final PortabilityRepository portabilityRepository;
    private final ModelMapper modelMapper;

    public PortabilityServiceImpl(PortabilityRepository portabilityRepository, ModelMapper modelMapper) {
        this.portabilityRepository = portabilityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Portability newPortability(InputPortability inputPortability) {
        Portability portability = Portability.builder()
                .user(modelMapper.map(inputPortability.getUser(), User.class))
                .portabilityStatus(PortabilityStatus.PROCESSANDO_PORTABILIDADE)
                .source(inputPortability.getPortability().getSource())
                .target(inputPortability.getPortability().getTarget())
                .build();

        return this.portabilityRepository.save(portability);
    }

    @Override
    public void putPortability(UUID id, UpdatePortabilityStatusDTO portabilityStatus) {
            var entity = portabilityRepository.findById(id);
            Portability portability = entity.orElseThrow(() -> new ResourceNotFoundException("Portabilidade não encontrada"));
            portability.setPortabilityStatus(portabilityStatus.getStatus());
            portabilityRepository.save(portability);
    }
}
