package br.com.sysmap.srcmsportability.framework.adapters.serviceConfig;

import org.springframework.context.annotation.Bean;

public class serviceBeanConfig {
    @Bean
    PortabilityService portabilityService(PortabilityPersistencePortOut portabilityPersistencePortOut){
        return new PortabilityService(portabilityPersistencePortOut);
    }
}
