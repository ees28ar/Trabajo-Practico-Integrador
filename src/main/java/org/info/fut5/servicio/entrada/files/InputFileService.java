package org.info.fut5.servicio.entrada.files;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;

import java.util.List;

public interface InputFileService {
    List<Jugador>LoadJugadorByFile(String rutaArchivo, Equipo equipo);
}
