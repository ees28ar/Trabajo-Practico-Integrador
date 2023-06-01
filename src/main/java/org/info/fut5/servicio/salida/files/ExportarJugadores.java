package org.info.fut5.servicio.salida.files;

import org.info.fut5.dominio.Jugador;

import java.util.List;

public interface ExportarJugadores {
    void exportarJugadores(List<Jugador> jugadores, String nombreEquipo, String nombreEntrenador, String rutaDestino);
}




