package org.info.fut5.servicio.entrada.MenuEntrada.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.servicio.busquedaservice.equipos.BusquedaDeEquipoService;
import org.info.fut5.servicio.busquedaservice.equipos.impl.BusquedaDeEquipoServiceImpl;
import org.info.fut5.servicio.busquedaservice.jugador.BusquedaJugadorService;
import org.info.fut5.servicio.busquedaservice.jugador.impl.BusquedaJugadorServiceImpl;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.entrada.MenuEntrada.MenuEntradaService;
import org.info.fut5.servicio.equipomanager.EquipoServicio;
import org.info.fut5.servicio.equipomanager.impl.EquipoServicioImpl;
import org.info.fut5.servicio.salida.files.OutPutFileService;
import org.info.fut5.servicio.salida.files.impl.OutPutFileServiceImpl;

import java.util.List;

public class MenuEntradaServiceImpl implements MenuEntradaService {
    private final EquipoServicio equipoManager;

    public MenuEntradaServiceImpl() {
        equipoManager = new EquipoServicioImpl();
    }

    @Override
    public void mostrarMenuEntrada() {
        boolean salir = false;
        Equipo equipoSeleccionado = null;
        do {
            System.out.println("\n\n\t*************************************************");
            System.out.println("\n\t  *BIENVENIDO AL GESTOR DE EQUIPOS DE FUTBOL 5*");
            System.out.println("                   by Eduardo Soto");
            System.out.println("\n\t*************************************************\n");
            System.out.println("INDIQUE LA ACCIÓN QUE DESEA REALIZAR: ");
            System.out.println("(1) CREAR EQUIPO");
            System.out.println("(2) MOSTRAR EQUIPOS");
            System.out.println("(3) BUSCAR JUGADOR POR NOMBRE");
            System.out.println("(4) BUSCAR UN EQUIPO POR NOMBRE (Se imprime Nombre, Entrenador y Capitán Del Equipo)");
            System.out.println("(5) BUSCAR UN EQUIPO POR NOMBRE (Se imprime Nombre, Entrenador y Lista de Jugadores)");
            System.out.println("(6) BUSCAR UN EQUIPO POR NOMBRE (Se imprime Nombre, Entrenador y Lista de Jugadores Ordenadas por Nombre)");
            System.out.println("(7) BUSCAR UN EQUIPO POR NOMBRE (Se imprime Nombre, Entrenador y Lista de Jugadores Ordenadas por número de camiseta)");
            System.out.println("(8) BUSCAR UN EQUIPO POR NOMBRE (Se imprime Nombre, Entrenador y Lista de Jugadores Ordenadas por número de camiseta y Posición)");
            System.out.println("(9) ELIMINAR UN EQUIPO DADO SU NOMBRE");
            System.out.println("(10) EXPORTAR LISTA DE JUGADORES HACIA UN ARCHIVO TXT.");
            System.out.println("(11) SALIR");
            int seleccionado = Inputservice.getScanner().nextInt();
            Inputservice.getScanner().nextLine();

            switch (seleccionado) {
                case 1:
                    equipoManager.crearEquipo();
                    break;
                case 2:
                    mostrarEquipos();
                    break;
                case 3:
                    buscarJugadorPorNombre();
                    break;
                case 4:
                    buscarEquipoPorNombre();
                    break;
                case 5:
                    buscarEquipoPorNombre2();
                    break;
                case 6:
                    buscarEquipoPorNombre3();
                    break;
                case 7:
                    buscarEquipoPorNombre5();
                    break;
                case 8:
                    buscarEquipoPorNombre6();
                    break;
                case 9:
                    eliminarEquipoPorNombre();
                    break;
                case 10:
                    exportarJugadores();
                    break;
                case 11:
                    salir = true;
                    System.out.println("GRACIAS POR UTILIZAR NUESTRO SISTEMA");
                    break;
                default:
                    System.out.println("Número ingresado no válido. Por favor, ingrese una opción válida.");
            }
        } while (!salir);
    }

    private void mostrarEquipos() {
        List<Equipo> equiposMostrar = equipoManager.getEquipos();
        for (Equipo equipo : equiposMostrar) {
            System.out.println("Equipo: " + equipo.toString());
            System.out.println("Entrenador: " + equipo.getEntrenador().getNombre());
            System.out.println("Jugadores: " + equipo.getJugadores().toString());
            System.out.println();
        }
    }

    private void buscarJugadorPorNombre() {
        List<Equipo> equipos = equipoManager.getEquipos();
        BusquedaJugadorService busquedaJugadorService = new BusquedaJugadorServiceImpl((EquipoServicioImpl) equipoManager);
        busquedaJugadorService.buscarJugadorPorNombre(equipos);
    }

    private void buscarEquipoPorNombre() {
        List<Equipo> equipoBuscar = equipoManager.getEquipos();
        BusquedaDeEquipoService busquedaEquipoPorNombre = new BusquedaDeEquipoServiceImpl(equipoManager);
        busquedaEquipoPorNombre.buscarEquipoPorNombre(equipoBuscar);
    }

    private void buscarEquipoPorNombre2() {
        List<Equipo> equipoBuscar2 = equipoManager.getEquipos();
        BusquedaDeEquipoService busquedaEquipoPorNombre2 = new BusquedaDeEquipoServiceImpl(equipoManager);
        busquedaEquipoPorNombre2.buscarEquipoPorNombre2(equipoBuscar2);
    }

    private void buscarEquipoPorNombre3() {
        List<Equipo> equipoBuscar4 = equipoManager.getEquipos();
        BusquedaDeEquipoService busquedaEquipoPorNombre3 = new BusquedaDeEquipoServiceImpl(equipoManager);
        busquedaEquipoPorNombre3.buscarEquipoPorNombre3(equipoBuscar4);
    }

    private void buscarEquipoPorNombre5() {
        List<Equipo> equipoBuscar5 = equipoManager.getEquipos();
        BusquedaDeEquipoService busquedaEquipoPorNombre5 = new BusquedaDeEquipoServiceImpl(equipoManager);
        busquedaEquipoPorNombre5.buscarEquipoPorNombre5(equipoBuscar5);
    }

    private void buscarEquipoPorNombre6() {
        List<Equipo> equipoBuscar6 = equipoManager.getEquipos();
        BusquedaDeEquipoService busquedaEquipoPorNombre6 = new BusquedaDeEquipoServiceImpl(equipoManager);
        busquedaEquipoPorNombre6.buscarEquipoPorNombre3(equipoBuscar6);
    }

    private void eliminarEquipoPorNombre() {
        List<Equipo> equipoBuscar3 = equipoManager.getEquipos();
        BusquedaDeEquipoService eliminarEquipoPorNombre = new BusquedaDeEquipoServiceImpl(equipoManager);
        eliminarEquipoPorNombre.eliminarEquipoPorNombre(equipoBuscar3);
    }

    private void exportarJugadores() {
        System.out.println("INGRESE RUTA DE DESTINO:");
        System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_salida.txt");
        String rutaDestino = Inputservice.getScanner().nextLine();
        OutPutFileService exportador = new OutPutFileServiceImpl();
        exportador.exportJugadores(equipoManager.getEquipos(), rutaDestino);
    }
}
