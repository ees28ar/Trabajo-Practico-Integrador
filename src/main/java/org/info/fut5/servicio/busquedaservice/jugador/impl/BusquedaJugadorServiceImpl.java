package org.info.fut5.servicio.busquedaservice.jugador.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.busquedaservice.jugador.BusquedaJugadorService;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.equipomanager.impl.EquipoServicioImpl;

import java.util.List;

public class BusquedaJugadorServiceImpl implements BusquedaJugadorService {



    public BusquedaJugadorServiceImpl(EquipoServicioImpl equipos) {
    }

    @Override
    public void buscarJugadorPorNombre(List<Equipo> equipos) {

        System.out.print("Ingrese el nombre del jugador que desea buscar: ");
        String nombreJugador = Inputservice.getScanner().nextLine();

        boolean jugadorEncontrado = false;

        for (Equipo equipo : equipos) {
            List<Jugador> jugadores = equipo.getJugadores();
            for (Jugador jugador : jugadores) {
                if (jugador.getNombre().equalsIgnoreCase(nombreJugador)) {
                    jugadorEncontrado = true;
                    System.out.println("Jugador encontrado:");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posición: " + jugador.getPosicion());
                    System.out.println("Es capitán: " + (jugador.isEsCapitan() ? "Sí" : "No"));
                    System.out.println("Equipo: " + equipo.getNombre());
                    System.out.println();
                }
            }
        }

        if (!jugadorEncontrado) {
            System.out.println("No se encontró ningún jugador con ese nombre.");
        }
    }
}



