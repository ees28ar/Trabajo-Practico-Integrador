package org.info.fut5.servicio.jugador;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;

import java.util.List;

public interface ServicioJugador {
    List<Jugador> crearListaJugadores(Equipo equipo);
}
