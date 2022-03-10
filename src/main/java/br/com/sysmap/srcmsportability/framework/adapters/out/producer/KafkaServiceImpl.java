package br.com.sysmap.srcmsportability.framework.adapters.out.producer;

import br.com.sysmap.srcmsportability.application.ports.in.KafkaService;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutPutKafkaPortabilityDTO;
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
    public void eventPortability(OutPutKafkaPortabilityDTO kafkaEvent) {
        Gson gson = new Gson();
        kafkaTemplate.send("src-ms-portability-create",gson.toJson(kafkaEvent));
    }
}
