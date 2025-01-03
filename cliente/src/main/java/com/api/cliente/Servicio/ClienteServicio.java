package com.api.cliente.Servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cliente.Entity.Cliente;
import com.api.cliente.Repositry.ClienteRepository;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findClientes(String nombre, String apellido) {
        return clienteRepository.findByNombreOrApellido(nombre,apellido);
    }
}
