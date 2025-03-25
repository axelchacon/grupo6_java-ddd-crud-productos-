package com.example.clientesapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad de dominio para representar un Producto.
 * Esta clase sigue los principios de inmutabilidad de DDD.
 */
@Getter
@ToString
@Builder
public class Cliente {
    private final UUID id;
    private final String nombre;
    private final String apellido;
    private final String dni;
    private final String email;
    private final Boolean activo;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaActualizacion;



    /**
     * Método para actualizar un producto con nuevos valores
     */
    public Cliente actualizar(String nombre, String apellido, String email, Boolean activo) {
        return Cliente.builder()
                .id(this.id)
                .nombre(nombre)
                .apellido(apellido)
                .email(email)
                .activo(this.activo)
                .fechaCreacion(this.fechaCreacion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    /**
     * Método para cambiar el estado activo del producto
     */
    public Cliente cambiarEstado(Boolean activo) {
        return Cliente.builder()
                .id(this.id)
                .nombre(this.nombre)
                .apellido(this.apellido)
                .email(this.email)
                .activo(activo)
                .fechaCreacion(this.fechaCreacion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }



}