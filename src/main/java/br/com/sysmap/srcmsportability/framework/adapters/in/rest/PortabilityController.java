package br.com.sysmap.srcmsportability.framework.adapters.in.rest;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PortabilityController {

    final PortabilityService portabilityService;

    public PortabilityController(PortabilityService portabilityService) {
        this.portabilityService = portabilityService;
    }



}


