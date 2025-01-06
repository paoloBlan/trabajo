package com.api.cliente.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteBuscarDTO;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Servicio.ClienteServicio;

import jakarta.validation.Valid;



@RestController   
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteService;
    
    @PostMapping("/buscar")
    public ResponseEntity<Object> buscarClientes(@Valid @RequestBody ClienteBuscarDTO cliente) {
        List<ClienteMostrarDTO> clientes = clienteService.findClientes(cliente.getNombre(), cliente.getApellido());
        return clientes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin datos disponibles")
                : ResponseEntity.ok(clientes);
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> guardarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.saveCliente(cliente);
            return ResponseEntity.ok("Cliente guardado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}