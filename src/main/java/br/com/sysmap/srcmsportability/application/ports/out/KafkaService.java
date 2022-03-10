package br.com.sysmap.srcmsportability.application.ports.out;

import br.com.sysmap.srcmsportability.domain.Portability;

public interface KafkaService {

    void eventPortability(Portability kafkaEvent);
}
