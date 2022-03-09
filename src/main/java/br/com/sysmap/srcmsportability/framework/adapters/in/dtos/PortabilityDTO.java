package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortabilityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'source' cannot be blank")
    private TelephoneCompany source;

    @NotBlank(message = "Field 'target' cannot be blank")
    private TelephoneCompany target;
}
