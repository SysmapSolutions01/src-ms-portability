package br.com.sysmap.srcmsportability.framework.adapters.out.producer;

import br.com.sysmap.srcmsportability.domain.Portability;
import com.google.gson.Gson;
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
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class KafkaServiceImplTests {
    EasyRandom easy = new EasyRandom();

    @Mock
    KafkaTemplate<String,String> kafkaTemplate;

    @InjectMocks
    KafkaServiceImpl kafkaService;

    @Test
    @DisplayName("KafkaService - eventPortability")
    void portabilityControllerNewPortability() {
        Portability portabilityEvent = easy.nextObject(Portability.class);
        Gson gson = new Gson();

        try {
            BDDMockito.given(kafkaTemplate.send(any(),any())).willReturn(null);
            BDDMockito.doNothing().when(kafkaTemplate).flush();

            kafkaService.eventPortability(portabilityEvent);
            BDDMockito.verify(kafkaTemplate, BDDMockito.times(1)).send(any(), any());
        } catch (Exception e) {
            Assertions.fail(e.getMessage(), e);
        }
    }
}
