package com.api.cliente.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.Entity.Cliente;
import com.api.cliente.Servicio.ClienteServicio;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteService;

    // Endpoint para buscar clientes por nombre o apellido usando POST
    @PostMapping("/buscar")
    public List<Cliente> buscarClientes(@RequestBody Cliente filtro) {
        return clienteService.findClientes(filtro.getNombre(), filtro.getApellido());
    }
}