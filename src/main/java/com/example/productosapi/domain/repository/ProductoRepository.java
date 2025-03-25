package com.example.productosapi.domain.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.clientesapi.domain.model.Cliente;

/**
 * Interfaz del repositorio de dominio para Clientes.
 * Define las operaciones de persistencia sin detalles de implementación.
 */
public interface ProductoRepository {

    /**
     * Guarda un nuevo cliente o actualiza uno existente
     * @param cliente el cliente a guardar
     * @return el cliente guardado
     */
    Cliente save(Cliente cliente);

    /**
     * Busca un cliente por su ID
     * @param id el ID del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findById(UUID id);

    /**
     * Busca un cliente por su código
     * @param dni el código del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findByDNI(String dni);

    /**
     * Obtiene todos los productos
     * @return lista de productos
     */
    List<Cliente> findAll();

    /**
     * Busca productos por nombre
     * @param nombre la nombre a buscar
     * @return lista de productos que pertenecen a la nombre
     */
    List<Cliente> findByNombre(String nombre);

    /**
     * Busca productos por apellido 
     * @param apellido la apellido a buscar
     * @return lista de productos que pertenecen al apellido  
     */
    List<Cliente> findByApellido(String apellido);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     */
    void deleteById(UUID id);

    /**
     * Verifica si existe un cliente con el código proporcionado
     * @param dni el código a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByDNI(String dni);
}