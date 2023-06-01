package org.info.fut5.servicio.busquedaservice.BusquedaDeEquiposService.impl;


import org.info.fut5.servicio.salida.files.ExportarJugadores;
import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.busquedaservice.BusquedaDeEquiposService.BusquedaDeEquipoService;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.equipomanager.EquipoServicio;
import org.info.fut5.servicio.salida.files.impl.ExportarJugadoresImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaDeEquipoServiceImpl implements BusquedaDeEquipoService {
    private EquipoServicio equipoManager;
    ExportarJugadores exportarJugadores = new ExportarJugadoresImpl();

    public BusquedaDeEquipoServiceImpl(EquipoServicio equipoManager) {
        this.equipoManager = equipoManager;
    }

    /*---BUSCA UN EQUIPO POR SU NOMBRE, IMPRIME SU NOMBRE, NOMBRE DE ENTRENADOR Y NOMBRE DEL CAPITÁN DEL EQUIPO.---*/
    @Override
    public void buscarEquipoPorNombre(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del jugador que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar) {
            List<Jugador> jugadores = equipo.getJugadores();
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                for (Jugador jugador : jugadores) {
                    if (jugador.isEsCapitan()) {
                        System.out.println("Capitan:" + jugador.getNombre());
                    }
                }
                System.out.println();
            }
        }
        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún jugador con ese nombre.");

        }
    }

    /*---BUSCA UN EQUIPO POR SU NOMBRE, IMPRIME SU NOMBRE, NOMBRE DEL ENTRENADOR Y LA LISTA DE LOS JUGADORES DEL EQUIPO.---*/

    @Override
    public void buscarEquipoPorNombre2(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del Equipo que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar2 = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar2) {
            List<Jugador> jugadores = equipo.getJugadores();
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                System.out.println("Lista de Jugadores: ");
                for (Jugador jugador : jugadores) {
                    System.out.println("** nombre=" + jugador.getNombre() + ", apellido=" + jugador.getApellido() + "id=" + jugador.getId() + ", altura=" + jugador.getAltura() + ", posicion=" + jugador.getPosicion() + ", cantidadGoles=" + jugador.getCantidadGoles() + ", cantidadPartidosJugados="
                            + jugador.getCantidadPartidosJugados() + ", esCapitan=" + jugador.isEsCapitan() + ", numeroCamiseta=" + jugador.getNumeroCamiseta() + ".");
                }
                 System.out.println();
            }
        }
        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún Equipo con ese nombre.");
        }


    }

    // elimina un equipo
    @Override
    public void eliminarEquipoPorNombre(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del equipo que desea eliminar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar3 = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar3) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                equipoBuscar3.remove(equipo);
                System.out.println("El equipo ha sido eliminado.");
                break;
            }
        }

        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún equipo con ese nombre.");
        }
    }

//●	Buscar un equipo por su nombre, donde se muestre su nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por su nombre.

    @Override
    public void buscarEquipoPorNombre3(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del Equipo que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar4 = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar4) {
            List<Jugador> jugadores = equipo.getJugadores();
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());

                List<Jugador> sortedList = jugadores.stream()
                        .sorted(Comparator.comparing(Jugador::getNombre))
                        .toList();
                //collect(Collectors.toList())
                System.out.println("Lista de Jugadores: ");
                sortedList.forEach(System.out::println);
                System.out.println("¿DESEA EXPORTAR LOS DATOS A UN ARCHIVO TIPO TXT?: (0) CANCELAR - (1) EXPORTAR: ");
                int exporta = Inputservice.getScanner().nextInt();
                Inputservice.getScanner().nextLine();
                if (exporta==1){
                    System.out.println("INGRESE RUTA DE DESTINO:");
                    System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_salida2.txt");
                    String rutaDestino= Inputservice.getScanner().nextLine();
                    exportarJugadores.exportarJugadores(sortedList, equipo.getNombre(), equipo.getEntrenador().getNombre(), rutaDestino);
                }
                System.out.println();
            }
        }

        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún Equipo con ese nombre.");
        }
    }

    //	Buscar un equipo por su nombre, donde se muestre su nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por camiseta.
    @Override
    public void buscarEquipoPorNombre5(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del Equipo que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar4 = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar4) {
            List<Jugador> jugadores = equipo.getJugadores();
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());

                List<Jugador> sortedList = jugadores.stream()
                        .sorted(Comparator.comparing(Jugador::getNumeroCamiseta))
                        .collect(Collectors.toList());
                //collect(Collectors.toList()
                System.out.println("Lista de Jugadores: ");
                sortedList.forEach(System.out::println);
                System.out.println("¿DESEA EXPORTAR LOS DATOS A UN ARCHIVO TIPO TXT?: (0) CANCELAR - (1) EXPORTAR: ");
                int exporta = Inputservice.getScanner().nextInt();
                Inputservice.getScanner().nextLine();
                if (exporta==1){
                    System.out.println("INGRESE RUTA DE DESTINO:");
                    System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_salida2.txt");
                    String rutaDestino= Inputservice.getScanner().nextLine();
                    exportarJugadores.exportarJugadores(sortedList, equipo.getNombre(), equipo.getEntrenador().getNombre(), rutaDestino);
                }
                System.out.println();
            }
        }

        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún Equipo con ese nombre.");
        }
    }
    //	Buscar un equipo por su nombre, donde se muestre su nombre, nombre del entrenador y la lista de los jugadores del equipo ordenados por camiseta y posicion.
    @Override
    public void buscarEquipoPorNombre6(List<Equipo> equipos) {
        System.out.print("Ingrese el nombre del Equipo que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar4 = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar4) {
            List<Jugador> jugadores = equipo.getJugadores();
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());

                List<Jugador> sortedList = jugadores.stream()
                        .sorted(Comparator.comparing(Jugador::getNumeroCamiseta)
                                .thenComparing(Comparator.comparing(Jugador::getPosicion)))
                        .collect(Collectors.toList());

                System.out.println("Lista de Jugadores: ");
                sortedList.forEach(System.out::println);
                System.out.println("¿DESEA EXPORTAR LOS DATOS A UN ARCHIVO TIPO TXT?: (0) CANCELAR - (1) EXPORTAR: ");
                int exporta = Inputservice.getScanner().nextInt();
                Inputservice.getScanner().nextLine();
                if (exporta==1){
                    System.out.println("INGRESE RUTA DE DESTINO:");
                    System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_salida.txt");
                    String rutaDestino= Inputservice.getScanner().nextLine();
                    exportarJugadores.exportarJugadores(sortedList, equipo.getNombre(), equipo.getEntrenador().getNombre(), rutaDestino);
                }
                System.out.println();
            }
        }

        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún Equipo con ese nombre.");
        }
    }
}
