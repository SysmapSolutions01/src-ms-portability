package br.com.sysmap.srcmsportability;

import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.application.services.PortabilityServiceImpl;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.User;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.UpdatePortabilityStatusDTO;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.PortabilityController;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutputPortabilityCreated;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PortabilityServiceImplTests {
    EasyRandom easy = new EasyRandom();

    @Mock
    PortabilityRepository portabilityRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    PortabilityServiceImpl portabilityService;

    @Test
    @DisplayName("PortabilityService - newPortability")
    void portabilityControllerNewPortability() {
        User userMapper = easy.nextObject(User.class);
        InputPortability inputPortability = easy.nextObject(InputPortability.class);
        Portability portabilitySaved = easy.nextObject(Portability.class);

        try {
            BDDMockito.given(modelMapper.map(any(), any())).willReturn(userMapper);
            BDDMockito.given(portabilityRepository.save(any())).willReturn(portabilitySaved);

            Portability portabilityCreated = portabilityService.newPortability(inputPortability);
            Assertions.assertNotNull(portabilityCreated);
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }

    @Test
    @DisplayName("PortabilityService - putPortability")
    void putPortability() {
        UUID inputId = UUID.randomUUID();
        UpdatePortabilityStatusDTO inputUpdateDTO = easy.nextObject(UpdatePortabilityStatusDTO.class);
        Portability portabilitySaved = easy.nextObject(Portability.class);

        Portability portabilityFound = easy.nextObject(Portability.class);
        Optional<Portability> portabilityFoundOptional = Optional.ofNullable(portabilityFound);

        try {
            BDDMockito.given(portabilityRepository.findById(any())).willReturn(portabilityFoundOptional);
            BDDMockito.given(portabilityRepository.save(any())).willReturn(portabilitySaved);

            portabilityService.putPortability(inputId, inputUpdateDTO);
            BDDMockito.verify(portabilityRepository, BDDMockito.times(1)).save(portabilityFound);
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }
}
