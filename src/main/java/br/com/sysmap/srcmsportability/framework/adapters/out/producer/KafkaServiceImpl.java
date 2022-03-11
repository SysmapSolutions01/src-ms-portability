package br.com.sysmap.srcmsportability.framework.adapters.out.producer;

import br.com.sysmap.srcmsportability.application.ports.out.KafkaService;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutPutKafkaPortabilityDTO;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.PortabilityDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaServiceImpl implements KafkaService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void eventPortability(Portability portability) {
        Gson gson = new Gson();
        kafkaTemplate.send("ocpv08td-src-ms-portability-create",gson.toJson(kafkaEventFactor(portability)));
        log.info("Payload enviado {}",kafkaEventFactor(portability));
    }

    private OutPutKafkaPortabilityDTO kafkaEventFactor(Portability portability) {
        OutPutKafkaPortabilityDTO kafka = new OutPutKafkaPortabilityDTO();
        kafka.setNumber(portability.getUser().getLine().getNumber());
        kafka.setDocumentNumber(portability.getUser().getDocumentNumber());
        kafka.setPortability(portabilityFactor(portability));
        return kafka;
    }

    private PortabilityDTO portabilityFactor(Portability portability) {
        PortabilityDTO portabilityDto = new PortabilityDTO();
        portabilityDto.setPortabilityId(portability.getPortabilityId());
        portabilityDto.setSource(portability.getSource());
        portabilityDto.setTarget(portability.getTarget());
        return portabilityDto;
    }
}
