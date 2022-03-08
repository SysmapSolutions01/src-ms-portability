package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputPortability implements Serializable {
    private static final long serialVersionUID = 1L;

    private UserDTO user;
    private PortabilityDTO portability;
}
