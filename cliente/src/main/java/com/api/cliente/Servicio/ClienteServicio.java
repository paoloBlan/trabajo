package com.api.cliente.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cliente.Entity.Cliente.Cliente;
import com.api.cliente.Entity.Cliente.ClienteMostrarDTO;
import com.api.cliente.Execption.ClienteNotFoundException;
import com.api.cliente.Repositry.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteMostrarDTO> findClientes(String nombre, String apellido) {
        return clienteRepository.findByNombreOrApellido(nombre, apellido);
    }

    public List<ClienteMostrarDTO> findClientes() {
        return clienteRepository.findAllCliente();
    }

    public void deleteCliente(int id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
           
        }else{
            throw new ClienteNotFoundException("cliente no existe");
        }
        
    }


    @Transactional
    public boolean saveCliente(Cliente cliente) {
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }

        int filasInsertadas = clienteRepository.saveCliente(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCiudad(),
                cliente.getPais());

        return filasInsertadas > 0;
    }

    @Transactional
    public boolean updateCliente(Cliente cliente) {
        if (!clienteRepository.existsById(cliente.getIdCliente())) {
            throw new IllegalArgumentException("el cliente no existe");
        }

        boolean isIdentical = clienteRepository.countIdenticalCliente(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getCiudad(),
                cliente.getPais()) > 0;

        if (!isIdentical) {
            clienteRepository.updateCliente(
                    cliente.getIdCliente(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getTelefono(),
                    cliente.getEmail(),
                    cliente.getCiudad(),
                    cliente.getPais());
            return true;
        }else{
            throw new IllegalArgumentException("datos  iguales");
        }
    }
}
