package com.example.clientesapi.infrastructure.persistence.repository;

import com.example.clientesapi.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio JPA para la entidad ProductoEntity
 */
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

    /**
     * Busca un producto por su código
     */
    Optional<ClienteEntity> findByCodigo(String codigo);

    /**
     * Busca productos por categoría
     */
    List<ClienteEntity> findByCategoria(String categoria);

    /**
     * Verifica si existe un producto con el código proporcionado
     */
    boolean existsByCodigo(String codigo);
}