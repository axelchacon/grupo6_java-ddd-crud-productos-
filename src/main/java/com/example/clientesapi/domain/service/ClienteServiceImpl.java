package com.example.clientesapi.domain.service;

import com.example.clientesapi.domain.exception.ClienteNotFoundException;
import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.example.clientesapi.domain.exception.BusinessException;

/**
 * Implementación del servicio de dominio para Productos
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        if (clienteRepository.existsByDNI(cliente.getDni())) {
            throw new BusinessException("Ya existe un cliente con el DNI: " + cliente.getDni());
        }

        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorId(UUID id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerClientePorDNI(String dni) {
        return clienteRepository.findByDNI(dni)
                .orElseThrow(() -> new ClienteNotFoundException(dni));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerClientesPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerClientesPorApellido(String apellido) {
        return clienteRepository.findByApellido(apellido);
    }

    @Override
    public Cliente actualizarCliente(UUID id, String nombre, String apellido, String email, Boolean activo) {
        Cliente clienteExistente = obtenerClientePorId(id);

        Cliente clienteActualizado = clienteExistente.actualizar(nombre, apellido, email, activo);

        return clienteRepository.save(clienteActualizado);
    }

    @Override
    public Cliente actualizarEstadoCliente(UUID id, Boolean activo) {
        Cliente productoExistente = obtenerClientePorId(id);

        Cliente productoActualizado = productoExistente.cambiarEstado(activo);

        return clienteRepository.save(productoActualizado);
    }

    @Override
    public void eliminarCliente(UUID id) {
        if (!clienteRepository.findById(id).isPresent()) {
            throw new ClienteNotFoundException(id);
        }

        clienteRepository.deleteById(id);
    }

}