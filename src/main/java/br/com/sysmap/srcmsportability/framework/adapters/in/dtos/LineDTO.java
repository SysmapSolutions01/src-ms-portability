package br.com.sysmap.srcmsportability.framework.adapters.in.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'number' cannot be blank")
    @Size(min = 9, max = 9, message = "Field 'number' must have 9 digits")
    private String number;
}
