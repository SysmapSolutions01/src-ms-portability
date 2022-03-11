package br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OutputPortabilityCreated implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID portabilityId;
}
