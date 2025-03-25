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
 * Controlador REST para operaciones de Clientes
 */
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final GetClienteUseCase getClienteUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;
    private final DeleteClienteUseCase deleteClienteUseCase;
    private final ClienteMapper mapper;

    /**
     * Crea un nuevo cliente
     */
    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = mapper.toDomain(request);
        Cliente creado = createClienteUseCase.execute(cliente);
        return new ResponseEntity<>(mapper.toResponse(creado), HttpStatus.CREATED);
    }

    /**
     * Obtiene un cliente por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerProducto(@PathVariable UUID id) {
        Cliente cliente = getClienteUseCase.executeById(id);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene un cliente por su dni
     */
    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClienteResponse> obtenerProductoPorCodigo(@PathVariable String dni) {
        Cliente cliente = getClienteUseCase.executeByCodigo(dni);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene todos los productos
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosProductos() {
        List<Cliente> productos = getClienteUseCase.executeAll();
        return ResponseEntity.ok(mapper.toResponseList(productos));
    }

    /**
     * Obtiene productos por nombre
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ClienteResponse>> obtenerProductosPorCategoria(@PathVariable String nombre) {
        List<Cliente> productos = getClienteUseCase.executeByNombre(nombre);
        return ResponseEntity.ok(mapper.toResponseList(productos));
    }

    /**
     * Obtiene productos por apellido
     */
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<ClienteResponse>> obtenerProductosPorApellido(@PathVariable String apellido) {
        List<Cliente> clientes = getClienteUseCase.executeByApellido(apellido);
        return ResponseEntity.ok(mapper.toResponseList(clientes));
    }

    /**
     * Actualiza un cliente existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarProducto(
            @PathVariable UUID id,
            @Valid @RequestBody ClienteUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.execute(
                id,
                request.getNombre(),
                request.getApellido(),
                request.getEmail()
                );

        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Actualiza el estado de un cliente
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ClienteResponse> actualizarEstadoProducto(
            @PathVariable UUID id,
            @Valid @RequestBody StatusUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.executeStateUpdate(id, request.getIsActive());
        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }


    /**
     * Elimina un cliente
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable UUID id) {
        deleteClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}