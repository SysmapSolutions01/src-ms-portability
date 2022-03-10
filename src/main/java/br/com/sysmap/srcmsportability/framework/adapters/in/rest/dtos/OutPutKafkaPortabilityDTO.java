package br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutKafkaPortabilityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String number;
    private String documentNumber;
    private PortabilityDTO portability;
}
