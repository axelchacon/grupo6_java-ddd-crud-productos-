package com.example.clientesapi.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Caso de uso para obtener productos
 */
@Component
@RequiredArgsConstructor
public class GetClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     */
    public Cliente executeById(UUID id) {
        return clienteService.obtenerClientePorId(id);
    }

    /**
     * Obtiene un cliente por su código
     * @param dni el código del cliente
     * @return el cliente encontrado
     */
    public Cliente executeByCodigo(String dni) {
        return clienteService.obtenerClientePorDNI(dni);
    }

    /**
     * Obtiene todos los productos
     * @return lista de todos los productos
     */
    public List<Cliente> executeAll() {
        return clienteService.obtenerTodosLosClientes();
    }

    /**
     * Obtiene productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos de la categoría
     */
    public List<Cliente> executeByNombre(String categoria) {
        return clienteService.obtenerClientesPorNombre(categoria);
    }

    /**
     * Obtiene productos por categoría
     * @param apellido la categoría a buscar
     * @return lista de productos de la categoría
     */
    public List<Cliente> executeByApellido(String apellido) {
        return clienteService.obtenerClientesPorApellido(apellido);
    }
}