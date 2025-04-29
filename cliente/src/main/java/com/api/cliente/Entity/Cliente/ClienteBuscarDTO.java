package com.api.cliente.Entity.Cliente;

import com.api.cliente.Validacion.ConstValidation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteBuscarDTO {
   
    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    private String nombre;
   
    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45 )
    private String apellido;
}
