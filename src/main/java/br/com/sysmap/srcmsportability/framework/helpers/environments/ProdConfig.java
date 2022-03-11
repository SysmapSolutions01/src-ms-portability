package br.com.sysmap.srcmsportability.framework.helpers.environments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Prod
@Slf4j
public class ProdConfig {

    @Bean
    public CommandLineRunner init(){
        return args -> {

            log.info("Executando em PROD");

        };
    }
}
