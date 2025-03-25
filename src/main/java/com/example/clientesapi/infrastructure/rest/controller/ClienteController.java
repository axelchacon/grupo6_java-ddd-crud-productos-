package com.example.clientesapi.infrastructure.rest.controller;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.infrastructure.persistence.mapper.ClienteMapper;
import com.example.clientesapi.infrastructure.rest.dto.ClienteRequest;
import com.example.clientesapi.infrastructure.rest.dto.ClienteResponse;
import com.example.clientesapi.infrastructure.rest.dto.ClienteUpdateRequest;
import com.example.clientesapi.infrastructure.rest.dto.StatusUpdateRequest;
import com.example.clientesapi.usecase.CreateClienteUseCase;
import com.example.clientesapi.usecase.DeleteClienteUseCase;
import com.example.clientesapi.usecase.GetClienteUseCase;
import com.example.clientesapi.usecase.UpdateClienteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para operaciones de Productos
 */
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ClienteController {

    private final CreateClienteUseCase createProductoUseCase;
    private final GetClienteUseCase getProductoUseCase;
    private final UpdateClienteUseCase updateProductoUseCase;
    private final DeleteClienteUseCase deleteProductoUseCase;
    private final ClienteMapper mapper;

    /**
     * Crea un nuevo producto
     */
    @PostMapping
    public ResponseEntity<ClienteResponse> crearProducto(@Valid @RequestBody ClienteRequest request) {
        Cliente producto = mapper.toDomain(request);
        Cliente creado = createProductoUseCase.execute(producto);
        return new ResponseEntity<>(mapper.toResponse(creado), HttpStatus.CREATED);
    }

    /**
     * Obtiene un producto por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerProducto(@PathVariable UUID id) {
        Cliente producto = getProductoUseCase.executeById(id);
        return ResponseEntity.ok(mapper.toResponse(producto));
    }

    /**
     * Obtiene un producto por su código
     */
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ClienteResponse> obtenerProductoPorCodigo(@PathVariable String codigo) {
        Cliente producto = getProductoUseCase.executeByCodigo(codigo);
        return ResponseEntity.ok(mapper.toResponse(producto));
    }

    /**
     * Obtiene todos los productos
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosProductos() {
        List<Cliente> productos = getProductoUseCase.executeAll();
        return ResponseEntity.ok(mapper.toResponseList(productos));
    }

    /**
     * Obtiene productos por categoría
     */
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ClienteResponse>> obtenerProductosPorCategoria(@PathVariable String categoria) {
        List<Cliente> productos = getProductoUseCase.executeByCategoria(categoria);
        return ResponseEntity.ok(mapper.toResponseList(productos));
    }

    /**
     * Actualiza un producto existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarProducto(
            @PathVariable UUID id,
            @Valid @RequestBody ClienteUpdateRequest request) {

        Cliente actualizado = updateProductoUseCase.execute(
                id,
                request.getNombre(),
                request.getDescripcion(),
                request.getPrecio(),
                request.getStock(),
                request.getCategoria()
        );

        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Actualiza el estado de un producto
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ClienteResponse> actualizarEstadoProducto(
            @PathVariable UUID id,
            @Valid @RequestBody StatusUpdateRequest request) {

        Cliente actualizado = updateProductoUseCase.executeStateUpdate(id, request.getActivo());
        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Actualiza el stock de un producto
     */
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ClienteResponse> actualizarStockProducto(
            @PathVariable UUID id,
            @Valid @RequestBody StatusUpdateRequest request) {

        Cliente actualizado = updateProductoUseCase.executeStockUpdate(id, request.getCantidad());
        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Elimina un producto
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable UUID id) {
        deleteProductoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}