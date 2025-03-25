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
     * Obtiene todos los clientes
     * @return lista de clientes
     */
    List<Cliente> obtenerTodosLosClientes();

    /**
     * Obtiene clientes por categoría
     * @param nombre la categoría a buscar
     * @return lista de clientes de la categoría
     */
    List<Cliente> obtenerClientesPorNombre(String nombre);

      /**
     * Obtiene clientes por categoría
     * @param apellido la categoría a buscar
     * @return lista de clientes de la categoría
     */
    List<Cliente> obtenerClientesPorApellido(String apellido);

    /**
     * Actualiza un cliente existente
     * @param id el ID del cliente a actualizar
     * @param nombre nuevo nombre
     * @param apellido nuevo apellido
     * @param email nuevo email
     * @param active si esta activo
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarCliente(UUID id, String nombre, String apellido,
                              String email, Boolean active);

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id el ID del cliente
     * @param activo el nuevo estado
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarEstadoCliente(UUID id, Boolean activo);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    void eliminarCliente(UUID id);

}