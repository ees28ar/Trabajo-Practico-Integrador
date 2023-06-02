package org.info.fut5.servicio.equipomanager;

import org.info.fut5.dominio.Equipo;

import java.util.List;

public interface EquipoServicio {
    void crearEquipo();
    List<Equipo> getEquipos();
    //void buscarJugadorPorNombre(List<Equipo> equipos);
}
