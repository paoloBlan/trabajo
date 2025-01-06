package com.api.cliente.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Repositry.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteMostrarDTO> findClientes(String nombre, String apellido) {
        return clienteRepository.findByNombreOrApellido(nombre,apellido);
    }

    @Transactional
    public boolean saveCliente(Cliente cliente) {
        int row = 0;
        if(clienteRepository.existsByEmail(cliente.getEmail())){
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }else{
            row = clienteRepository.saveCliente(cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getEmail(),cliente.getCiudad(), cliente.getPais());
        }
       
        return row > 0 ? true : false;
    }
}
