package com.example.clientesapi.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Caso de uso para actualizar productos
 */
@Component
@RequiredArgsConstructor
public class UpdateClienteUseCase {

    private final ClienteService productoService;

    /**
     * Actualiza un cliente existente
     * @param id ID del cliente a actualizar
     * @param nombre nuevo nombre
     * @param apellido nueva descripción
     * @param email nuevo precio
     * @return el cliente actualizado
     */
    public Cliente execute(UUID id, String nombre, String apellido, String email) {
        return productoService.actualizarCliente(id, nombre, apellido, nombre);
    }

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id ID del cliente
     * @param activo nuevo estado
     * @return el cliente actualizado
     */
    public Cliente executeStateUpdate(UUID id, Boolean activo) {
        return productoService.actualizarEstadoCliente(id, activo);
    }

}