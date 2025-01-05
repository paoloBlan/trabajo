package com.api.cliente.Entity.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
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

    @Column(length = 45)
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚÑñ ]+$", message = "El nombre solo puede contener letras y espacios.")
    private String nombre;

    @Column(length = 45)
    private String apellido;

    @Column(length = 45)
    private String telefono;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String ciudad;

    @Column(length = 45)
    private String pais;

    public Cliente(int idCliente, String nombre, String apellido, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    } 
    
    
}