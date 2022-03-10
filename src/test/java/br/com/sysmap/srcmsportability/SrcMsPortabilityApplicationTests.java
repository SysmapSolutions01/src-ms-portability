package br.com.sysmap.srcmsportability;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.domain.Portability;
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
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SrcMsPortabilityApplicationTests {

	EasyRandom easy = new EasyRandom();

	@Mock
	PortabilityService portabilityService;

	@InjectMocks
	PortabilityController portabilityController;


	@Test
	@DisplayName("PortabilityController - newPortability")
	void portabilityControllerNewPortability() {
		InputPortability param = easy.nextObject(InputPortability.class);
		Portability response = easy.nextObject(Portability.class);
		try {
			BDDMockito.given(portabilityService.newPortability(any())).willReturn(response);
			ResponseEntity<OutputPortabilityCreated> outputPortabilityCreated = portabilityController.newPortability(param);
			Assertions.assertNotNull(outputPortabilityCreated);
		} catch (Exception e) {
			Assertions.fail(e.getMessage(), e);
		}
	}

	@Test
	@DisplayName("PortabilityController - putPortability")
	void portabilityControllerPutPortability() {
		UUID param1 = easy.nextObject(UUID.class);
		UpdatePortabilityStatusDTO param2 = easy.nextObject(UpdatePortabilityStatusDTO.class);

		try {
			BDDMockito.doNothing().when(portabilityService).putPortability(any(), any());
			ResponseEntity<String> response = portabilityController.putPortability(param1, param2);
			Assertions.assertNotNull(response);
		} catch (Exception e) {
			Assertions.fail(e.getMessage(), e);
		}
	}

}
