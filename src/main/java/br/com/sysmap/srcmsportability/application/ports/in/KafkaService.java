package br.com.sysmap.srcmsportability.application.ports.in;

import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutPutKafkaPortabilityDTO;

public interface KafkaService {

    void eventPortability(OutPutKafkaPortabilityDTO kafkaEvent);
}
