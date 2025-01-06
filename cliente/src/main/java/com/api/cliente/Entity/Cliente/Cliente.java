package com.api.cliente.Entity.Cliente;

import com.api.cliente.Validacion.ConstValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Cliente {
    @Id
    @Column(name = "idCliente")
    private int idCliente;

    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    @Column(length = 45)
    private String nombre;

    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    @Column(length = 45)
    private String apellido;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Número de teléfono inválido. Debe contener entre 7 y 15 dígitos y puede incluir un prefijo '+'")
    @NotBlank(message = "es obligatorio")
    private String telefono;

    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    @Column(length = 45)
    private String email;

    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    @Column(length = 45)
    private String ciudad;

    @NotBlank(message = ConstValidation.MESSAGE_VACIO)
    @Pattern(regexp = ConstValidation.PATTERN_LETRAS, message = ConstValidation.MESSAGE_LETRAS_ESPACIOS)
    @Size(max = ConstValidation.MAX_45, message = ConstValidation.MESSAGE_MAX_45)
    @Column(length = 45)
    private String pais;
 
}