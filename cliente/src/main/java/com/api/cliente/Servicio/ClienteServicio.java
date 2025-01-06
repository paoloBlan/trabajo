package com.api.cliente.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Repositry.ClienteRepository;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteMostrarDTO> findClientes(String nombre, String apellido) {
        return clienteRepository.findByNombreOrApellido(nombre,apellido);
    }

    public boolean saveCliente(Cliente cliente) {
        int row = clienteRepository.saveCliente(cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getEmail(),cliente.getCiudad(), cliente.getPais());
        return row > 0 ? true : false;
    }
}
