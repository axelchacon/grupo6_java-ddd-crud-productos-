package com.example.clientesapi.usecase;

import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Caso de uso para eliminar un cliente
 */
@Component
@RequiredArgsConstructor
public class DeleteClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Ejecuta el caso de uso para eliminar un cliente
     * @param id ID del cliente a eliminar
     */
    public void execute(UUID id) {
        clienteService.eliminarCliente(id);
    }
}