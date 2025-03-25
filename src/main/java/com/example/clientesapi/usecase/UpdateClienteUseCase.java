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
     * Actualiza un producto existente
     * @param id ID del producto a actualizar
     * @param nombre nuevo nombre
     * @param descripcion nueva descripción
     * @param precio nuevo precio
     * @param stock nuevo stock
     * @param categoria nueva categoría
     * @return el producto actualizado
     */
    public Cliente execute(UUID id, String nombre, String descripcion,
                           BigDecimal precio, Integer stock, String categoria) {
        return productoService.actualizarProducto(id, nombre, descripcion, precio, stock, categoria);
    }

    /**
     * Actualiza el estado (activo/inactivo) de un producto
     * @param id ID del producto
     * @param activo nuevo estado
     * @return el producto actualizado
     */
    public Cliente executeStateUpdate(UUID id, Boolean activo) {
        return productoService.actualizarEstadoProducto(id, activo);
    }

    /**
     * Actualiza el stock de un producto
     * @param id ID del producto
     * @param cantidad cantidad a añadir (positivo) o restar (negativo)
     * @return el producto actualizado
     */
    public Cliente executeStockUpdate(UUID id, Integer cantidad) {
        return productoService.actualizarStock(id, cantidad);
    }
}