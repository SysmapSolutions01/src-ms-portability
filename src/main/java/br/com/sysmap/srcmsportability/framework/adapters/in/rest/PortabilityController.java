package br.com.sysmap.srcmsportability.framework.adapters.in.rest;

import br.com.sysmap.srcmsportability.application.ports.in.PortabilityService;
import br.com.sysmap.srcmsportability.domain.Portability;
import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import br.com.sysmap.srcmsportability.framework.adapters.in.dtos.InputPortability;
import br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos.OutputPortability;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/portability")
public class PortabilityController {

    final PortabilityService portabilityService;

    public PortabilityController(PortabilityService portabilityService) {
        this.portabilityService = portabilityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputPortability newPortability(@RequestBody InputPortability inputPortability) {
        Portability portability = this.portabilityService.newPortability(inputPortability);
        return new OutputPortability(portability.getPortabilityId());
    }

    @PutMapping(value = "/{portabilityId}")
    public ResponseEntity<String> putPortability(@PathVariable UUID portabilityId, @RequestBody PortabilityStatus status){
        portabilityService.putPortability(portabilityId,status);
        log.info("Callback recebido com sucesso, status: {}", status);
        return ResponseEntity.ok().body("Portabilidade recebida, status: " + status+ "!");
    }
}
