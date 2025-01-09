package com.api.cliente.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteBuscarDTO;
import com.api.cliente.Entity.Cliente.ClienteEliminarDTO;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Execption.ClienteNotFoundException;
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

    @GetMapping("/all")
    public ResponseEntity<Object> all() {
        List<ClienteMostrarDTO> clientes = clienteService.findClientes();

        return clientes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin datos disponibles")
                : ResponseEntity.ok(clientes);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@Valid @RequestBody ClienteEliminarDTO clienteEliminarDTO) {
        try {
            clienteService.deleteCliente(clienteEliminarDTO.getIdCliente());
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    

    @PostMapping("/agregar")
    public ResponseEntity<String> guardarCliente(@Valid @RequestBody Cliente cliente) {
        try {
            boolean isEmailClienteExist = clienteService.saveCliente(cliente);
            if (isEmailClienteExist) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Existe email");
            }
            return ResponseEntity.ok("Cliente agregado con éxito.");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> editarCliente(@Valid @RequestBody Cliente cliente) {
        try {

            boolean isClienteModificado = clienteService.updateCliente(cliente);

            if (isClienteModificado) {
                return ResponseEntity.ok("Cliente moficado con éxito.");
            }

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se pudo modificar el cliente. Verifica los datos proporcionados.");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}