package org.info.fut5.servicio.salida.files;

import org.info.fut5.dominio.Equipo;


import java.util.List;

public interface OutPutFileService {
    void exportJugadores(List<Equipo> equipos, String rutaDeDestino);
}
