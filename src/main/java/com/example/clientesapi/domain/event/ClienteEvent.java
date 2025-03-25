package com.example.clientesapi.domain.event;

import com.example.clientesapi.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Evento de dominio para productos
 * Se puede utilizar para implementar Event Sourcing o publicar eventos
 */
@Getter
@AllArgsConstructor
public class ClienteEvent {

    public enum TipoEvento {
        CREADO, ACTUALIZADO, ELIMINADO, ESTADO_CAMBIADO, STOCK_ACTUALIZADO
    }

    private final UUID id;
    private final TipoEvento tipo;
    private final Cliente cliente;
    private final LocalDateTime timestamp;

    /**
     * Crea un evento de cliente creado
     */
    public static ClienteEvent creado(Cliente cliente) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.CREADO,
                cliente,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de cliente actualizado
     */
    public static ClienteEvent actualizado(Cliente cliente) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ACTUALIZADO,
                cliente,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de cliente eliminado
     */
    public static ClienteEvent eliminado(Cliente cliente) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ELIMINADO,
                cliente,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de estado de cliente cambiado
     */
    public static ClienteEvent estadoCambiado(Cliente cliente) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ESTADO_CAMBIADO,
                cliente,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de stock de cliente actualizado
     */
    public static ClienteEvent stockActualizado(Cliente cliente) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.STOCK_ACTUALIZADO,
                cliente,
                LocalDateTime.now()
        );
    }
}