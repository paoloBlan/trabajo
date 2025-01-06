package com.api.cliente.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    boolean existsByEmail(String email);
    
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

    @Modifying
    @Query(value = """
            INSERT INTO cliente (idCliente, nombre, apellido, telefono, email, ciudad, pais) 
            VALUES (:idCliente, :nombre, :apellido, AES_ENCRYPT(:telefono, 'ventas2024'), :email, :ciudad, :pais)
            """, nativeQuery = true)
    int saveCliente(@Param("idCliente") Integer idCliente,
                    @Param("nombre") String nombre, 
                    @Param("apellido") String apellido,
                    @Param("telefono") String telefono, 
                    @Param("email") String email, 
                    @Param("ciudad") String ciudad, 
                    @Param("pais") String pais);

}
