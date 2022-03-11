package br.com.sysmap.srcmsportability.framework.adapters.in.rest.dtos;

import br.com.sysmap.srcmsportability.domain.enums.TelephoneCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortabilityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID portabilityId;
    @Enumerated(EnumType.STRING)
    private TelephoneCompany source;
    @Enumerated(EnumType.STRING)
    private TelephoneCompany target;
}
