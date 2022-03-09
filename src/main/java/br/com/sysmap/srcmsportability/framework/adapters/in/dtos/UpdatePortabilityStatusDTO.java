package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import br.com.sysmap.srcmsportability.domain.enums.PortabilityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePortabilityStatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'status' cannot be blank")
    private PortabilityStatus status;
}
