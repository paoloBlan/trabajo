package com.api.cliente.Entity.Cliente;

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
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚÑñ ]+$", message = "El nombre solo puede contener letras y espacios.")
    @NotBlank(message = "El nombre debe ser obligatorio")
    @Size(max = 45, message = "Solo se permite 45 letras")
    private String nombre;
    
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚÑñ ]+$", message = "El Apellido solo puede contener letras y espacios.")
    @NotBlank(message = "El nombre debe ser obligatorio")
    @Size(max = 45, message = "Solo se permite 45 letras")
    private String apellido;
}
