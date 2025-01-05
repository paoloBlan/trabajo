package com.api.cliente.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    @Query(value = """
        SELECT idCliente,nombre, apellido, cast(AES_DECRYPT(telefono, 'ventas2024') as char) AS telefono
        FROM cliente
        WHERE TRIM(nombre) = TRIM(:nombre)
           OR TRIM(apellido) = TRIM(:apellido)
        """, nativeQuery = true)
    List<ClienteMostrarDTO> findByNombreOrApellido(
        @Param("nombre") String nombre,
        @Param("apellido") String apellido
    );
}
