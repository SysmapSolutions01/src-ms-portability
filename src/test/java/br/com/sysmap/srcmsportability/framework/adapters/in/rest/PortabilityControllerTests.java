package br.com.sysmap.srcmsportability.framework.adapters.in.rest;

import br.com.sysmap.srcmsportability.SrcMsPortabilityApplication;
import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.UpdatePortabilityStatusDTO;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutputPortabilityCreated;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(
    classes = SrcMsPortabilityApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class PortabilityControllerTests {
    EasyRandom easy = new EasyRandom();

    @Autowired
    Validator validator;

    @Mock
    PortabilityService portabilityService;

    @InjectMocks
    PortabilityController portabilityController;

    InputPortability inputPortability;

    Portability portability;

    @BeforeEach
    void fillInputs() {
        inputPortability = easy.nextObject(InputPortability.class);
        portability = easy.nextObject(Portability.class);
    }

    @Test
    @DisplayName("PortabilityController - Field 'user' cannot be null")
    void portabilityControllerNewPortabilityUserCannotBeNull() {
        inputPortability.setUser(null);
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'portability' cannot be null")
    void portabilityControllerNewPortabilityPortabilityCannotBeNull() {
        inputPortability.setPortability(null);
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'name' cannot be blank")
    void portabilityControllerNewPortabilityNameCannotBeBlank() {
        inputPortability.getUser().setName("");
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'documentNumber' must be a valid CPF")
    void portabilityControllerNewPortabilityDocumentNumberMustBeAValidCPF() {
        inputPortability.getUser().setDocumentNumber("12345678910");
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'dateOfBirth' must be a past date")
    void portabilityControllerNewPortabilityDateOfBirthMustBeAPastDate() {
        inputPortability.getUser().setDateOfBirth(LocalDate.of(2020, 01, 01));
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'line' cannot be null")
    void portabilityControllerNewPortabilityLineCannotBeNull() {
        inputPortability.getUser().setLine(null);
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - Field 'address' cannot be null")
    void portabilityControllerNewPortabilityAddressCannotBeNull() {
        inputPortability.getUser().setAddress(null);
        final Set<ConstraintViolation<InputPortability>> violations = validator.validate(inputPortability);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    @DisplayName("PortabilityController - newPortability")
    void portabilityControllerNewPortability() {
        Portability response = portability;
        try {
            BDDMockito.given(portabilityService.newPortability(any())).willReturn(response);
            ResponseEntity<OutputPortabilityCreated> outputPortabilityCreated = portabilityController.newPortability(inputPortability);
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
