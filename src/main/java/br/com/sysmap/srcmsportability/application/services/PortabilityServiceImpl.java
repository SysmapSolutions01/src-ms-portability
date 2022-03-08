package br.com.sysmap.srcmsportability.application.services;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.domain.Address;
import br.com.sysmap.srcmsportability.domain.Line;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.User;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.UpdatePortabilityStatusDTO;
import br.com.sysmap.srcmsportability.framework.exceptions.ResourceNotFoundException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

public class PortabilityServiceImpl implements PortabilityService {

    private final PortabilityRepository portabilityRepository;

    public PortabilityServiceImpl(PortabilityRepository portabilityRepository) {
        this.portabilityRepository = portabilityRepository;
    }

    @Override
    public Portability newPortability(InputPortability inputPortability) {
        Line line = new Line();
        line.setNumber(
            inputPortability.getUser().getLine().getNumber()
        );

        Address address = Address.builder()
                .street(inputPortability.getUser().getAddress().getStreet())
                .number(inputPortability.getUser().getAddress().getNumber())
                .country(inputPortability.getUser().getAddress().getCountry())
                .city(inputPortability.getUser().getAddress().getCity())
                .stateOrRegion(inputPortability.getUser().getAddress().getStateOrRegion())
                .build();

        User user = User.builder()
                .line(line)
                .address(address)
                .name(inputPortability.getUser().getName())
                .dateOfBirth(inputPortability.getUser().getDateOfBirth())
                .documentNumber(inputPortability.getUser().getDocumentNumber())
                .build();

        Portability portability = Portability.builder()
                .user(user)
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
