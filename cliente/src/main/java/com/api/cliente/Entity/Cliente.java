package com.api.cliente.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Cliente {
    
    @Id
    @Column(name = "idCliente")
    private int idCliente;

    @Column(length = 45)
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
}