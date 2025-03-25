package com.example.clientesapi.domain.service;

import com.example.clientesapi.domain.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de dominio para la lógica de negocio relacionada con Clientes
 */
public interface ClienteService {

    /**
     * Crea un nuevo cliente
     * @param cliente el cliente a crear
     * @return el cliente creado
     */
    Cliente crearCliente(Cliente cliente);

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     * @throws ProductoNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorId(UUID id);

    /**
     * Obtiene un cliente por su código
     * @param codigo el código del cliente
     * @return el cliente encontrado
     * @throws ProductoNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorDNI(String codigo);

    /**
     * Obtiene todos los productos
     * @return lista de productos
     */
    List<Cliente> obtenerTodosLosClientes();

    /**
     * Obtiene productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos de la categoría
     */
    List<Cliente> obtenerProductosPorNombre(String nombre);

      /**
     * Obtiene productos por categoría
     * @param categoria la categoría a buscar
     * @return lista de productos de la categoría
     */
    List<Cliente> obtenerProductosPorApellido(String apellido);

    /**
     * Actualiza un cliente existente
     * @param id el ID del cliente a actualizar
     * @param nombre nuevo nombre
     * @param descripcion nueva descripción
     * @param precio nuevo precio
     * @param stock nuevo stock
     * @param categoria nueva categoría
     * @return el cliente actualizado
     * @throws ProductoNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarCliente(UUID id, String nombre, String descripcion,
                               BigDecimal precio, Integer stock, String categoria);

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id el ID del cliente
     * @param activo el nuevo estado
     * @return el cliente actualizado
     * @throws ProductoNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarEstadoCliente(UUID id, Boolean activo);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     * @throws ProductoNotFoundException si no se encuentra el cliente
     */
    void eliminarCliente(UUID id);

}