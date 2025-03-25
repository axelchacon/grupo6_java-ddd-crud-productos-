package com.example.clientesapi.domain.service;

import com.example.clientesapi.domain.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de dominio para la lógica de negocio relacionada con Productos
 */
public interface ClienteService {

    /**
     * Crea un nuevo producto
     * @param producto el producto a crear
     * @return el producto creado
     */
    Cliente crearProducto(Cliente producto);

    /**
     * Obtiene un producto por su ID
     * @param id el ID del producto
     * @return el producto encontrado
     * @throws ProductoNotFoundException si no se encuentra el producto
     */
    Cliente obtenerProductoPorId(UUID id);

    /**
     * Obtiene un producto por su código
     * @param codigo el código del producto
     * @return el producto encontrado
     * @throws ProductoNotFoundException si no se encuentra el producto
     */
    Cliente obtenerProductoPorCodigo(String codigo);

    /**
     * Obtiene todos los productos
     * @return lista de productos
     */
    List<Cliente> obtenerTodosLosProductos();

    /**
     * Obtiene productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos de la categoría
     */
    List<Cliente> obtenerProductosPorCategoria(String categoria);

    /**
     * Actualiza un producto existente
     * @param id el ID del producto a actualizar
     * @param nombre nuevo nombre
     * @param descripcion nueva descripción
     * @param precio nuevo precio
     * @param stock nuevo stock
     * @param categoria nueva categoría
     * @return el producto actualizado
     * @throws ProductoNotFoundException si no se encuentra el producto
     */
    Cliente actualizarProducto(UUID id, String nombre, String descripcion,
                               BigDecimal precio, Integer stock, String categoria);

    /**
     * Actualiza el estado (activo/inactivo) de un producto
     * @param id el ID del producto
     * @param activo el nuevo estado
     * @return el producto actualizado
     * @throws ProductoNotFoundException si no se encuentra el producto
     */
    Cliente actualizarEstadoProducto(UUID id, Boolean activo);

    /**
     * Elimina un producto por su ID
     * @param id el ID del producto a eliminar
     * @throws ProductoNotFoundException si no se encuentra el producto
     */
    void eliminarProducto(UUID id);

    /**
     * Actualiza el stock de un producto
     * @param id el ID del producto
     * @param cantidad la cantidad a añadir (positivo) o restar (negativo)
     * @return el producto con el stock actualizado
     * @throws ProductoNotFoundException si no se encuentra el producto
     * @throws BusinessException si no hay suficiente stock para reducir
     */
    Cliente actualizarStock(UUID id, Integer cantidad);
}