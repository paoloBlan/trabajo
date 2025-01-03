package com.api.cliente.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.cliente.Entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = """
        SELECT nombre, apellido, AES_DECRYPT(telefono, 'ventas2024') AS telefono
        FROM cliente
        WHERE TRIM(nombre) = TRIM(:nombre)
           OR TRIM(apellido) = TRIM(:apellido)
        """, nativeQuery = true)
    List<Cliente> findByNombreOrApellido(
        @Param("nombre") String nombre,
        @Param("apellido") String apellido
    );
}
