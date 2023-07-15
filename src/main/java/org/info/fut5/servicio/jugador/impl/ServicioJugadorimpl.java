package org.info.fut5.servicio.jugador.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.dominio.Posicion;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.jugador.ServicioJugador;
import org.info.fut5.servicio.posicion.PosicionService;
import org.info.fut5.servicio.posicion.impl.PosicionServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

public class ServicioJugadorimpl implements ServicioJugador {
    private final PosicionService posicionService = new PosicionServiceImpl();

    @Override
    public List<Jugador> crearListaJugadores(Equipo equipo) {
        List<Jugador> jugadores = new ArrayList<>();
        System.out.println("A continuación, ingrese los datos de cada uno de los jugadores que integran el equipo:");
        System.out.println("=====================================================================================");
        int consulta = 0;
        ingresarJugadores(equipo, jugadores, consulta);
        return jugadores;
    }

    private void ingresarJugadores(Equipo equipo, List<Jugador> jugadores, int consulta) {
        for (int i = 0; i < 6; i++) {
            boolean esCapitan = false; // Guardar el capitán
            UUID idJugador = UUID.randomUUID();
            System.out.println("Ingrese los datos del jugador " + (i + 1) + ":");
            String nombreJugador = "";
            do {
                System.out.print("Nombre: ");
                try {
                    if (Inputservice.getScanner().hasNextInt()) {
                        throw new InputMismatchException("Se esperaba un valor de tipo String, no un entero");
                    }
                    nombreJugador = Inputservice.getScanner().nextLine();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    Inputservice.getScanner().nextLine();
                }
            } while (nombreJugador.isEmpty());

            System.out.print("Apellido: ");
            String apellidoJugador = Inputservice.getScanner().nextLine();
            double alturaJugador = 0.0;
            do {
                System.out.print("Ingrese la altura del jugador: ");
                try {
                    alturaJugador = Inputservice.getScanner().nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo double.");
                    Inputservice.getScanner().nextLine();
                }
            } while (alturaJugador <= 0.0);

            int golesJugador = 0;
            do {
                System.out.print("Cantidad de goles: ");
                try {
                    golesJugador = Inputservice.getScanner().nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    Inputservice.getScanner().nextLine();
                }
            } while (golesJugador <= 0);

            int partidosJugador = 0;
            do {
                System.out.print("Cantidad de Partidos Jugados: ");
                try {
                    partidosJugador = Inputservice.getScanner().nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    Inputservice.getScanner().nextLine();
                }
            } while (partidosJugador <= 0);

            int camisetaJugador = 0;
            do {
                System.out.print("Número de Camiseta: ");
                try {
                    camisetaJugador = Inputservice.getScanner().nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    Inputservice.getScanner().nextLine();
                }
            } while (camisetaJugador <= 0);

            Posicion posicionJugador = posicionService.establecerPosicion();

            if (!esCapitan) {
                if (consulta != 1) {
                    System.out.print("¿El jugador es capitán del equipo? Ingrese (0) para NO o (1) para SÍ: ");
                    consulta = Inputservice.getScanner().nextInt();
                    esCapitan = (consulta == 1);
                }
            }

            Inputservice.getScanner().nextLine();

            Jugador jugador = new Jugador(idJugador, nombreJugador, apellidoJugador, alturaJugador, posicionJugador,
                    golesJugador, partidosJugador, esCapitan, camisetaJugador, equipo);

            jugadores.add(jugador);
        }
    }
}