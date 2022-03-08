package br.com.sysmap.srcmsportability.framework.adapters.config;

import br.com.sysmap.srcmsportability.SrcMsPortabilityApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SrcMsPortabilityApplication.class)
public class serviceConfig {
    @Bean
    PortabilityService portabilityService(PortabilityRepository portabilityRepository){
        return new PortabilityService(portabilityRepository);
    }
}
