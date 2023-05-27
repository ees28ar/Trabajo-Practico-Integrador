package org.info.fut5.servicio.posicion;

import org.info.fut5.dominio.Posicion;

public interface PosicionService {
    Posicion establecerPosicion();

    Posicion getNombre(String nombre);
}
