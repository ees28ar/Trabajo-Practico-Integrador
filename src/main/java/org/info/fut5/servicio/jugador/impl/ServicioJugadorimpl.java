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

import static org.info.fut5.servicio.entrada.console.Inputservice.scanner;

public class ServicioJugadorimpl implements ServicioJugador {
    private final PosicionService posicionService = new PosicionServiceImpl();

    @Override
    public List<Jugador> crearListaJugadores(Equipo equipo) {
        List<Jugador> jugadores = new ArrayList<>();
        System.out.println("A continuación, Ingrese los Datos de cada uno de los Jugadores que integran el Equipo: ");
        System.out.println("=====================================================================================");
        //Inputservice.getScanner().nextLine();
        int consulta=0;
        ingresaJugadores(equipo, jugadores, consulta);
        return jugadores;
    }

    private void ingresaJugadores(Equipo equipo, List<Jugador> jugadores, int consulta) {
        for (int i = 0; i < 6; i++) {
            boolean EsCapitan = false; // Guardar el capitán
            UUID idJugador= UUID.randomUUID();
            System.out.println("Ingrese los datos del jugador " + (i + 1) + ":");
            String nombreJugador = "";
            do {
                System.out.print("nombre: ");
                try {
                    if (scanner.hasNextInt()) {
                        throw new InputMismatchException("Se esperaba un valor de tipo String, no un entero");
                    }
                    nombreJugador = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            } while (nombreJugador.isEmpty());

            System.out.print("Apellido: ");
            String apellidoJugador = Inputservice.getScanner().nextLine();
            double alturaJugador = 0.0;
            do {
                System.out.print("Ingrese la altura del jugador: ");
                try {
                    alturaJugador = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo double.");
                    scanner.nextLine();
                }
            } while (alturaJugador <= 0.0);


            int golesJugador = 0;
            do {
                System.out.print("Cantidad de goles: ");
                try {
                    golesJugador = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    scanner.nextLine();
                }
            } while (golesJugador <= 0);

            int partidosJugador = 0;
            do {
                System.out.print("Cantidad de Partidos Jugados: ");
                try {
                    partidosJugador = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    scanner.nextLine();
                }
            } while (partidosJugador <= 0);

            int camisetaJugador = 0;
            do {
                System.out.print("Número de Camiseta: ");
                try {
                    camisetaJugador = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error: Se esperaba un valor de tipo entero.");
                    scanner.nextLine();
                }
            } while (camisetaJugador <= 0);

            Posicion posicionJugador= posicionService.establecerPosicion();

            if (!EsCapitan) {
                if (consulta != 1){
                    System.out.print("¿El jugador es capitán del equipo? Ingrese (0) para NO o (1) para SÍ: ");
                    consulta = Inputservice.getScanner().nextInt();
                    EsCapitan = (consulta == 1);
                }
            }

            Inputservice.getScanner().nextLine();

            Jugador jugador = new Jugador(idJugador, nombreJugador, apellidoJugador, alturaJugador, posicionJugador, golesJugador,
                    partidosJugador, EsCapitan, camisetaJugador, equipo);


            jugadores.add(jugador);


        }
    }

}
