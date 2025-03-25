package com.example.clientesapi.domain.repository;

import com.example.clientesapi.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz del repositorio de dominio para Clientes.
 * Define las operaciones de persistencia sin detalles de implementación.
 */
public interface ClienteRepository {

    /**
     * Guarda un nuevo producto o actualiza uno existente
     * @param producto el producto a guardar
     * @return el producto guardado
     */
    Cliente save(Cliente producto);

    /**
     * Busca un producto por su ID
     * @param id el ID del producto
     * @return un Optional con el producto si existe
     */
    Optional<Cliente> findById(UUID id);

    /**
     * Busca un producto por su código
     * @param codigo el código del producto
     * @return un Optional con el producto si existe
     */
    Optional<Cliente> findByCodigo(String codigo);

    /**
     * Obtiene todos los productos
     * @return lista de productos
     */
    List<Cliente> findAll();

    /**
     * Busca productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos que pertenecen a la categoría
     */
    List<Cliente> findByCategoria(String categoria);

    /**
     * Elimina un producto por su ID
     * @param id el ID del producto a eliminar
     */
    void deleteById(UUID id);

    /**
     * Verifica si existe un producto con el código proporcionado
     * @param codigo el código a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByCodigo(String codigo);
}