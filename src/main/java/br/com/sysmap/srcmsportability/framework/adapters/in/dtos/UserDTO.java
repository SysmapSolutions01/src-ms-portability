package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'name' cannot be blank")
    private String name;

    @NotBlank(message = "Field 'documentNumber' cannot be blank")
    @CPF(message = "Field 'documentNumber' must be a valid CPF")
    private String documentNumber;

    @NotBlank(message = "Field 'dateOfBirth' cannot be blank")
    @Past(message = "Field 'dateOfBirth' must be a past date")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Field 'line' cannot be blank")
    private LineDTO line;

    @NotBlank(message = "Field 'address' cannot be blank")
    private AddressDTO address;
}
