package com.api.cliente.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.cliente.Entity.Cliente.ClienteBuscarDTO;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Servicio.ClienteServicio;



@RestController   
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteService;
    
    
    @PostMapping("/buscar")
    public List<ClienteMostrarDTO> buscarClientes(@Validated @RequestBody ClienteBuscarDTO cliente ) {
        return clienteService.findClientes(cliente.getNombre(), cliente.getApellido());
    }
}