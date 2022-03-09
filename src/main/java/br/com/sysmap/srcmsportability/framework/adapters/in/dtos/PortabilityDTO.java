package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortabilityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Field 'source' cannot be null")
    private TelephoneCompany source;

    @NotNull(message = "Field 'target' cannot be null")
    private TelephoneCompany target;
}
