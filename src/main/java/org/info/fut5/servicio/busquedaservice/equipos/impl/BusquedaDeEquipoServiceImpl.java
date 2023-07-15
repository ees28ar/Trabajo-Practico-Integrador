package org.info.fut5.servicio.busquedaservice.equipos.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.busquedaservice.equipos.BusquedaDeEquipoService;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.equipomanager.EquipoServicio;
import org.info.fut5.servicio.salida.files.ExportarJugadores;
import org.info.fut5.servicio.salida.files.impl.ExportarJugadoresImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaDeEquipoServiceImpl implements BusquedaDeEquipoService {
    private EquipoServicio equipoManager;
    private ExportarJugadores exportarJugadores;

    public BusquedaDeEquipoServiceImpl(EquipoServicio equipoManager) {
        this.equipoManager = equipoManager;
        this.exportarJugadores = new ExportarJugadoresImpl();
    }

    @Override
    public void buscarEquipoPorNombre(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, false, Comparator.comparing(Jugador::getNombre));
    }

    @Override
    public void buscarEquipoPorNombre2(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, false, null);
    }

    @Override
    public void eliminarEquipoPorNombre(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, true, null);
    }

    @Override
    public void buscarEquipoPorNombre3(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, true, Comparator.comparing(Jugador::getNombre));
    }

    @Override
    public void buscarEquipoPorNombre5(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, true, Comparator.comparing(Jugador::getNumeroCamiseta));
    }

    @Override
    public void buscarEquipoPorNombre6(List<Equipo> equipos) {
        buscarEquipoPorNombreInternal(equipos, true, Comparator.comparing(Jugador::getNumeroCamiseta).thenComparing(Comparator.comparing(Jugador::getPosicion)));
    }

    private void buscarEquipoPorNombreInternal(List<Equipo> equipos, boolean exportar, Comparator<Jugador> comparator) {
        System.out.print("Ingrese el nombre del equipo que desea buscar: ");
        String nombreEquipo = Inputservice.getScanner().nextLine();

        boolean equipoEncontrado = false;
        List<Equipo> equipoBuscar = equipoManager.getEquipos();
        for (Equipo equipo : equipoBuscar) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                equipoEncontrado = true;
                System.out.println("Nombre: " + equipo.getNombre());
                System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());

                List<Jugador> jugadores = equipo.getJugadores();
                if (comparator != null) {
                    jugadores = jugadores.stream()
                            .sorted(comparator)
                            .collect(Collectors.toList());
                }

                System.out.println("Lista de Jugadores: ");
                jugadores.forEach(System.out::println);

                if (exportar) {
                    System.out.println("¿DESEA EXPORTAR LOS DATOS A UN ARCHIVO TIPO TXT?: (0) CANCELAR - (1) EXPORTAR: ");
                    int exporta = Inputservice.getScanner().nextInt();
                    Inputservice.getScanner().nextLine();
                    if (exporta == 1) {
                        System.out.println("INGRESE RUTA DE DESTINO:");
                        System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_salida.txt");
                        String rutaDestino = Inputservice.getScanner().nextLine();
                        exportarJugadores.exportarJugadores(jugadores, equipo.getNombre(), equipo.getEntrenador().getNombre(), rutaDestino);
                    }
                }

                System.out.println();
                break;
            }
        }

        if (!equipoEncontrado) {
            System.out.println("No se encontró ningún equipo con ese nombre.");
        }
    }
}
