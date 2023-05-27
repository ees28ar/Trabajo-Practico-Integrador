package org.info.fut5.servicio.busquedaservice.BusquedaJugadorService;

import org.info.fut5.dominio.Equipo;

import java.util.List;

public interface BusquedaJugadorService {
    void buscarJugadorPorNombre(List<Equipo> equipos);
}
