package com.api.cliente.Entity.Cliente;

import com.api.cliente.Validacion.ConstValidation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEliminarDTO {
    @Min(value = 1, message = ConstValidation.MESSAGE_NUM_POSITVO)
    @NotNull(message = ConstValidation.MESSAGE_NULL)
    private Integer idCliente;
}