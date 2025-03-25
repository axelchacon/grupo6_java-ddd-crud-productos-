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

    private final ClienteService productoService;

    /**
     * Obtiene un producto por su ID
     * @param id el ID del producto
     * @return el producto encontrado
     */
    public Cliente executeById(UUID id) {
        return productoService.obtenerProductoPorId(id);
    }

    /**
     * Obtiene un producto por su código
     * @param codigo el código del producto
     * @return el producto encontrado
     */
    public Cliente executeByCodigo(String codigo) {
        return productoService.obtenerProductoPorCodigo(codigo);
    }

    /**
     * Obtiene todos los productos
     * @return lista de todos los productos
     */
    public List<Cliente> executeAll() {
        return productoService.obtenerTodosLosProductos();
    }

    /**
     * Obtiene productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos de la categoría
     */
    public List<Cliente> executeByCategoria(String categoria) {
        return productoService.obtenerProductosPorCategoria(categoria);
    }
}