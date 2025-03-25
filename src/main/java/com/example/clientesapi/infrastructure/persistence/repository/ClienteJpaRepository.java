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
     * Busca un cliente por su dni
     */
    Optional<ClienteEntity> findByDni(String dni);

    /**
     * Busca productos por nombre
     */
    List<ClienteEntity> findByNombre(String nombre);


    /**
     * Busca productos por apellido
     */
    List<ClienteEntity> findByApellido(String apellido);

    /**
     * Verifica si existe un cliente con el dni proporcionado
     */
    boolean existsByDni(String dni);
}