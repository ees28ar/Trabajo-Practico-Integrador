package org.info.fut5.servicio.entrada.MenuEntrada.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.servicio.busquedaservice.BusquedaDeEquiposService.BusquedaDeEquipoService;
import org.info.fut5.servicio.busquedaservice.BusquedaDeEquiposService.impl.BusquedaDeEquipoServiceImpl;
import org.info.fut5.servicio.busquedaservice.BusquedaJugadorService.BusquedaJugadorService;
import org.info.fut5.servicio.busquedaservice.BusquedaJugadorService.impl.BusquedaJugadorServiceImpl;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.entrada.MenuEntrada.MenuEntradaService;
import org.info.fut5.servicio.equipomanager.EquipoServicio;
import org.info.fut5.servicio.equipomanager.impl.EquipoServicioImpl;

import java.util.List;

public class MenuEntradaServiceImpl implements MenuEntradaService {
    private final EquipoServicio equipoManager;

    public MenuEntradaServiceImpl() {
        equipoManager = new EquipoServicioImpl();
    }

    @Override
    public void mostrarMenuEntrada() {
        boolean salir = false;

        do {
            System.out.println("\n\n\t*************************************************");
            System.out.println("\n\t  *BIENVENIDO AL GESTOR DE EQUIPOS DE FUTBOL 5*");
            System.out.println("\n\t*************************************************\n");
            System.out.println("INDIQUE LA ACCIÓN QUE DESEA REALIZAR: ");
            System.out.println("(1) CREAR EQUIPO");
            System.out.println("(2) MOSTRAR EQUIPOS");
            System.out.println("(3) BUSCAR JUGADOR POR NOMBRE");
            System.out.println("(4) BUSCAR UN EQUIPO NOMBRE, (Se imprime Nombre, Entrenador y Capitán Del Equipo)");
            System.out.println("(5) BUSCAR UN EQUIPO NOMBRE, (Se imprime Nombre, Entrenador y Lista de Jugadores)");
            System.out.println("(6) BUSCAR UN EQUIPO NOMBRE, (Se imprime Nombre, Entrenador y Lista de Jugadores Ordenadas por Nombre)");
            System.out.println("(7) ELIMINAR UN EQUIPO DADO SU NOMBRE");
            System.out.println("(8) SALIR");
            int seleccionado = Inputservice.getScanner().nextInt();
            Inputservice.getScanner().nextLine();

            switch (seleccionado) {
                case 1:
                    // método crearEquipo para crear un equipo
                    equipoManager.crearEquipo();
                    break;
                case 2:
                    //  lista de equipos creados
                    List<Equipo> equiposMostrar = equipoManager.getEquipos();
                    // Imprimir los equipos
                    for (Equipo equipo : equiposMostrar) {
                        System.out.println("Equipo: " + equipo.toString());
                        System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
                        System.out.println("Jugadores: " + equipo.getJugadores().toString());
                        System.out.println();
                    }
                    break;
                case 3:
                    // lista de equipos creados
                    List<Equipo> equipos = equipoManager.getEquipos();
                    // instancia de BusquedaJugadorServiceImpl
                    BusquedaJugadorService busquedaJugadorService = new BusquedaJugadorServiceImpl((EquipoServicioImpl) equipoManager);
                    // buscarJugadorPorNombre pasando la lista de equipos
                    busquedaJugadorService.buscarJugadorPorNombre(equipos);
                    break;
                case 4:
                    // lista de equipos creados
                    List<Equipo> equipoBuscar = equipoManager.getEquipos();
                    // instancia de BusquedaDeEquipoServiceImpl y pasar EquipoServicio
                    BusquedaDeEquipoService busquedaEquipoPorNombre = new BusquedaDeEquipoServiceImpl(equipoManager);
                    //  buscarJugadorPorNombre pasando la lista de equipos
                    busquedaEquipoPorNombre.buscarEquipoPorNombre(equipoBuscar);
                    break;
                case 5:
                    // lista de equipos creados
                    List<Equipo> equipoBuscar2 = equipoManager.getEquipos();
                    // instancia de BusquedaDeEquipoServiceImpl pasando EquipoServicio
                    BusquedaDeEquipoService busquedaEquipoPorNombre2 = new BusquedaDeEquipoServiceImpl(equipoManager);
                    // buscarJugadorPorNombre pasando la lista de equipos
                    busquedaEquipoPorNombre2.buscarEquipoPorNombre2(equipoBuscar2);
                    break;
                case 6:
                    //  la lista de equipos creados
                    List<Equipo> equipoBuscar4 = equipoManager.getEquipos();
                    //  instancia de BusquedaDeEquipoServiceImpl pasando EquipoServicio
                    BusquedaDeEquipoService busquedaEquipoPorNombre3 = new BusquedaDeEquipoServiceImpl(equipoManager);
                    //  buscarJugadorPorNombre pasando la lista de equipos
                    busquedaEquipoPorNombre3.buscarEquipoPorNombre3(equipoBuscar4);
                    break;
                case 7:
                    // lista de equipos creados
                    List<Equipo> equipoBuscar3 = equipoManager.getEquipos();
                    // Cinstancia de BusquedaDeEquipoServiceImpl pasando EquipoServicio
                    BusquedaDeEquipoService eliminarEquipoPorNombre = new BusquedaDeEquipoServiceImpl(equipoManager);
                    // metodo eliminarEquipoPorNombree pasando la lista de equipos
                    eliminarEquipoPorNombre.eliminarEquipoPorNombre(equipoBuscar3);
                    break;
                case 8:
                    salir = true;
                    break;
                default:
                    System.out.println("Número ingresado no válido. Por favor, ingrese una opción válida.");
            }
        } while (!salir);
    }


}
