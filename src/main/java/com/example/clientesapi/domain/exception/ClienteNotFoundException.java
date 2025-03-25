package com.example.clientesapi.domain.exception;

import java.util.UUID;

/**
 * Excepción de dominio para cuando no se encuentra un producto
 */
public class ClienteNotFoundException extends BusinessException {

    public ClienteNotFoundException(UUID id) {
        super("No se encontró el producto con ID: " + id);
    }

    public ClienteNotFoundException(String codigo) {
        super("No se encontró el producto con código: " + codigo);
    }
}