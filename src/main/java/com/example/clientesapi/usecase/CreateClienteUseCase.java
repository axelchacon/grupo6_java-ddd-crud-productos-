package com.example.clientesapi.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Caso de uso para crear un producto
 */
@Component
@RequiredArgsConstructor
public class CreateClienteUseCase {

    private final ClienteService productoService;

    /**
     * Ejecuta el caso de uso
     * @param producto el producto a crear
     * @return el producto creado
     */
    public Cliente execute(Cliente producto) {
        return productoService.crearProducto(producto);
    }
}