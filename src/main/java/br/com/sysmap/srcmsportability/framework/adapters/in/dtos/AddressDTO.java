package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'street' cannot be blank")
    private String street;

    @NotBlank(message = "Field 'number' cannot be blank")
    private String number;

    @NotBlank(message = "Field 'city' cannot be blank")
    private String city;

    @NotBlank(message = "Field 'country' cannot be blank")
    private String country;

    @NotBlank(message = "Field 'stateOrRegion' cannot be blank")
    private String stateOrRegion;
}
