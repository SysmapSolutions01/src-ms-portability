package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import br.com.sysmap.srcmsportability.framework.helpers.validation.TelephoneCompanySourceConstraint;
import br.com.sysmap.srcmsportability.framework.helpers.validation.TelephoneCompanyTargetConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortabilityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @TelephoneCompanySourceConstraint
    @NotNull(message = "Field 'source' cannot be null")
    private TelephoneCompany source;

    @TelephoneCompanyTargetConstraint
    @NotNull(message = "Field 'target' cannot be null")
    private TelephoneCompany target;
}
