package com.example.clientesapi.domain.service;

import com.example.clientesapi.domain.exception.BusinessException;
import com.example.clientesapi.domain.exception.ClienteNotFoundException;
import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Implementación del servicio de dominio para Productos
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository productoRepository;

    @Override
    public Cliente crearProducto(Cliente producto) {
        if (productoRepository.existsByCodigo(producto.getCodigo())) {
            throw new BusinessException("Ya existe un producto con el código: " + producto.getCodigo());
        }

        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerProductoPorId(UUID id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente obtenerProductoPorCodigo(String codigo) {
        return productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ClienteNotFoundException(codigo));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> obtenerProductosPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public Cliente actualizarProducto(UUID id, String nombre, String descripcion,
                                      BigDecimal precio, Integer stock, String categoria) {
        Cliente productoExistente = obtenerProductoPorId(id);

        Cliente productoActualizado = productoExistente.actualizar(
                nombre,
                descripcion,
                precio,
                stock,
                categoria
        );

        return productoRepository.save(productoActualizado);
    }

    @Override
    public Cliente actualizarEstadoProducto(UUID id, Boolean activo) {
        Cliente productoExistente = obtenerProductoPorId(id);

        Cliente productoActualizado = productoExistente.cambiarEstado(activo);

        return productoRepository.save(productoActualizado);
    }

    @Override
    public void eliminarProducto(UUID id) {
        if (!productoRepository.findById(id).isPresent()) {
            throw new ClienteNotFoundException(id);
        }

        productoRepository.deleteById(id);
    }

    @Override
    public Cliente actualizarStock(UUID id, Integer cantidad) {
        Cliente producto = obtenerProductoPorId(id);
        Cliente productoActualizado;

        if (cantidad >= 0) {
            productoActualizado = producto.aumentarStock(cantidad);
        } else {
            try {
                productoActualizado = producto.reducirStock(Math.abs(cantidad));
            } catch (IllegalArgumentException e) {
                throw new BusinessException("No hay suficiente stock disponible para el producto: " + id);
            }
        }

        return productoRepository.save(productoActualizado);
    }
}