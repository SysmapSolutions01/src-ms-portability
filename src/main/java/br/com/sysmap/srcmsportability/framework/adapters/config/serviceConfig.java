package br.com.sysmap.srcmsportability.framework.adapters.config;

import br.com.sysmap.srcmsportability.SrcMsPortabilityApplication;
import br.com.sysmap.srcmsportability.application.ports.out.PortabilityRepository;
import br.com.sysmap.srcmsportability.application.services.PortabilityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SrcMsPortabilityApplication.class)
public class serviceConfig {
    @Bean
    PortabilityServiceImpl portabilityService(PortabilityRepository portabilityRepository){
        return new PortabilityServiceImpl(portabilityRepository);
    }
}
