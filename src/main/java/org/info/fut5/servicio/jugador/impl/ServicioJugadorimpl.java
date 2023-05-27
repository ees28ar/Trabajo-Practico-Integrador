package org.info.fut5.servicio.jugador.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.dominio.Posicion;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.jugador.ServicioJugador;
import org.info.fut5.servicio.posicion.PosicionService;
import org.info.fut5.servicio.posicion.impl.PosicionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ServicioJugadorimpl implements ServicioJugador {
    private final PosicionService posicionService = new PosicionServiceImpl();

    @Override
    public List<Jugador> crearListaJugadores(Equipo equipo) {
        List<Jugador> jugadores = new ArrayList<>();
        System.out.println("A continuación, Ingrese los Datos de cada uno de los Jugadores que integran el Equipo: ");
        System.out.println("=====================================================================================");
        Inputservice.getScanner().nextLine(); // Limpia el Scanner

        int consulta=0;
        for (int i = 0; i < 2; i++) {
            boolean EsCapitan = false; // Guardar el capitán

            UUID idJugador= UUID.randomUUID();
            System.out.println("Ingrese los datos del jugador " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombreJugador = Inputservice.getScanner().nextLine();
            System.out.print("Apellido: ");
            String apellidoJugador = Inputservice.getScanner().nextLine();
            System.out.print("Altura: ");
            double alturaJugador = Inputservice.getScanner().nextDouble();
            System.out.print("Cantidad de Goles: ");
            int golesJugador = Inputservice.getScanner().nextInt();
            System.out.print("Cantidad de Partidos Jugados: ");
            int partidosJugador = Inputservice.getScanner().nextInt();
            System.out.print("Número de Camiseta: ");
            int camisetaJugador = Inputservice.getScanner().nextInt();
            Posicion posicionJugador= posicionService.establecerPosicion();


            if (!EsCapitan) {
                if (consulta != 1){
                    System.out.print("¿El jugador es capitán del equipo? Ingrese (0) para NO o (1) para SÍ: ");
                    consulta = Inputservice.getScanner().nextInt();
                    EsCapitan = (consulta == 1);
                }
            }

            Inputservice.getScanner().nextLine(); // Limpia el Scanner

            Jugador jugador = new Jugador(idJugador, nombreJugador, apellidoJugador, alturaJugador, posicionJugador, golesJugador,
                    partidosJugador, EsCapitan, camisetaJugador, equipo);


            jugadores.add(jugador);


        }
        return jugadores;
    }

}
