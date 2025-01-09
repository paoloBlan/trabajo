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
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    boolean existsByEmail(String email);

    @Query(value = """
            SELECT idCliente,nombre, apellido, cast(AES_DECRYPT(telefono, 'ventas2024') as char) AS telefono
            FROM cliente
            WHERE TRIM(nombre) = TRIM(:nombre)
               OR TRIM(apellido) = TRIM(:apellido)
            """, nativeQuery = true)
    List<ClienteMostrarDTO> findByNombreOrApellido(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido);


    @Query(value = """
            SELECT idCliente,nombre, apellido, cast(AES_DECRYPT(telefono, 'ventas2024') as char) AS telefono
            FROM cliente
            """, nativeQuery = true)
    List<ClienteMostrarDTO> findAllCliente();

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

    @Query(value = """
            SELECT COUNT(*)
            FROM cliente
            WHERE idCliente = :idCliente
              AND nombre = :nombre
              AND apellido = :apellido
              AND telefono = AES_ENCRYPT(:telefono, 'ventas2024')
              AND email = :email
              AND ciudad = :ciudad
              AND pais = :pais
            """, nativeQuery = true)
    int countIdenticalCliente(@Param("idCliente") Integer idCliente,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("telefono") String telefono,
            @Param("email") String email,
            @Param("ciudad") String ciudad,
            @Param("pais") String pais);

    @Modifying
    @Query(value = """
            UPDATE cliente
            SET nombre = :nombre,
                apellido = :apellido,
                telefono = AES_ENCRYPT(:telefono, 'ventas2024'),
                email = :email,
                ciudad = :ciudad,
                pais = :pais
            WHERE idCliente = :idCliente
            """, nativeQuery = true)
    int updateCliente(@Param("idCliente") Integer idCliente,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("telefono") String telefono,
            @Param("email") String email,
            @Param("ciudad") String ciudad,
            @Param("pais") String pais);

}
