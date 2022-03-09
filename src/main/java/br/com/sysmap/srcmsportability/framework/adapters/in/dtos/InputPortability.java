package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputPortability implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'user' cannot be blank")
    private UserDTO user;

    @NotBlank(message = "Field 'portability' cannot be blank")
    private PortabilityDTO portability;
}
