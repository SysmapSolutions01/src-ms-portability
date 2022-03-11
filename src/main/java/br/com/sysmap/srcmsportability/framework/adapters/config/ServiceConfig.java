package br.com.sysmap.srcmsportability.framework.adapters.config;

import br.com.sysmap.srcmsportability.SrcMsPortabilityApplication;
import br.com.sysmap.srcmsportability.application.ports.out.KafkaService;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.application.services.PortabilityServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SrcMsPortabilityApplication.class)
public class ServiceConfig {
    @Bean
    PortabilityServiceImpl portabilityService(PortabilityRepository portabilityRepository, ModelMapper modelMapper, KafkaService kafkaService){
        return new PortabilityServiceImpl(portabilityRepository, modelMapper, kafkaService);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
