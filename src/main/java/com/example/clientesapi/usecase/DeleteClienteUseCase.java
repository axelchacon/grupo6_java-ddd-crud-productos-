package com.example.clientesapi.usecase;

import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Caso de uso para eliminar un producto
 */
@Component
@RequiredArgsConstructor
public class DeleteClienteUseCase {

    private final ClienteService productoService;

    /**
     * Ejecuta el caso de uso para eliminar un producto
     * @param id ID del producto a eliminar
     */
    public void execute(UUID id) {
        productoService.eliminarProducto(id);
    }
}