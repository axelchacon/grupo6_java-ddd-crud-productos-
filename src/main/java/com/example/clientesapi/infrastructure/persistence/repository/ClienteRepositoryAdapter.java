package com.example.clientesapi.infrastructure.persistence.repository;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.repository.ClienteRepository;
import com.example.clientesapi.infrastructure.persistence.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementación del repositorio de dominio que utiliza el repositorio JPA
 * Implementa el patrón Adapter para conectar el dominio con la infraestructura
 */
@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;
    private final ClienteMapper mapper;

    @Override
    public Cliente save(Cliente producto) {
        var entity = mapper.toEntity(producto);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Cliente> findByCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> findByCategoria(String categoria) {
        return jpaRepository.findByCategoria(categoria).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCodigo(String codigo) {
        return jpaRepository.existsByCodigo(codigo);
    }
}