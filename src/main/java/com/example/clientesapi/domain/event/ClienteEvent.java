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
    private final Cliente producto;
    private final LocalDateTime timestamp;

    /**
     * Crea un evento de producto creado
     */
    public static ClienteEvent creado(Cliente producto) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.CREADO,
                producto,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de producto actualizado
     */
    public static ClienteEvent actualizado(Cliente producto) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ACTUALIZADO,
                producto,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de producto eliminado
     */
    public static ClienteEvent eliminado(Cliente producto) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ELIMINADO,
                producto,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de estado de producto cambiado
     */
    public static ClienteEvent estadoCambiado(Cliente producto) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.ESTADO_CAMBIADO,
                producto,
                LocalDateTime.now()
        );
    }

    /**
     * Crea un evento de stock de producto actualizado
     */
    public static ClienteEvent stockActualizado(Cliente producto) {
        return new ClienteEvent(
                UUID.randomUUID(),
                TipoEvento.STOCK_ACTUALIZADO,
                producto,
                LocalDateTime.now()
        );
    }
}