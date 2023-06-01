package org.info.fut5.servicio.equipomanager.impl;

import org.info.fut5.dominio.Entrenador;
import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.busquedaservice.BusquedaJugadorService.BusquedaJugadorService;
import org.info.fut5.servicio.busquedaservice.BusquedaJugadorService.impl.BusquedaJugadorServiceImpl;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.entrada.files.InputFileService;
import org.info.fut5.servicio.entrada.files.impl.InputFileServiceImpl;
import org.info.fut5.servicio.entrenador.EntrenadorService;
import org.info.fut5.servicio.entrenador.impl.EntrenadorServiceImpl;
import org.info.fut5.servicio.equipomanager.EquipoServicio;
import org.info.fut5.servicio.jugador.ServicioJugador;
import org.info.fut5.servicio.jugador.impl.ServicioJugadorimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EquipoServicioImpl implements EquipoServicio {
    private List<Equipo> equipos;
    private final EntrenadorService entrenadorService = new EntrenadorServiceImpl();
    private final ServicioJugador jugadorService = new ServicioJugadorimpl();
    private final InputFileService inputFileService = new InputFileServiceImpl();

    public EquipoServicioImpl() {
        equipos = new ArrayList<>();

    }




    @Override
    public void crearEquipo() {
        int condicion = 1;
        do {
            System.out.print("INGRESE EL NOMBRE DEL EQUIPO: ");
            String nombre = Inputservice.getScanner().nextLine();
            Entrenador newEntrenador = entrenadorService.crearEntrenador();
            LocalDateTime fechaCreacion = LocalDateTime.now();
            // Crea equipo sin jugadores
            Equipo equipo = new Equipo(nombre, fechaCreacion, newEntrenador, new ArrayList<>());
            System.out.println("Indique como desea cargar la lista de Jugadores: (0) Manual - (1) Importar Lista");
            int cargaJugador = Inputservice.getScanner().nextInt();
            Inputservice.getScanner().nextLine();
            if (cargaJugador==1){
                System.out.println("INGRESE RUTA DEL ARCHIVO:");
                System.out.println("ejempo: src/main/java/org/info/fut5/resources/jugadores_entrada.txt");
                String ruta= Inputservice.getScanner().nextLine();
                List<Jugador> jugadores =inputFileService.LoadJugadorByFile(ruta,equipo);
                // Agrega los jugadores al equipo
                equipo.setJugadores(jugadores);
                System.out.println("Lista de Jugadrores cargados exitosamente de: "+ ruta);
         }else {
                //  lista de jugadores
                List<Jugador> nuevaListaJugadores = jugadorService.crearListaJugadores(equipo);

                // Actualizar la lista de jugadores del equipo
                equipo.setJugadores(nuevaListaJugadores);
            }
            equipos.add(equipo);

            System.out.println("Equipo creado y agregado a la lista de equipos.");
            System.out.println("DESEA CARGAR OTRO EQUIPO: PRESIONE (1) PARA CONTINUAR ó (0) PARA FINALIZAR");
            condicion = Inputservice.getScanner().nextInt();
            Inputservice.getScanner().nextLine();
        } while (condicion == 1);


    }
    @Override
    public void buscarJugadorPorNombre(List<Equipo> equipos) {
        BusquedaJugadorService busquedaJugadorService = new BusquedaJugadorServiceImpl(this);
        //(EquipoServicioImpl) equipos
        busquedaJugadorService.buscarJugadorPorNombre(equipos);
    }


    @Override
    public List<Equipo> getEquipos() {
        return equipos;
    }



}