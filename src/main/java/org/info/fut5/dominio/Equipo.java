package org.info.fut5.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private LocalDateTime fechaCreacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores= new ArrayList<>();


    public Equipo(String nombre, LocalDateTime fechaCreacion, Entrenador entrenador, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador;
        this.jugadores = (List<Jugador>) jugadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo [nombre=").append(nombre).append(", Fecha de Creacion=").append(fechaCreacion);
        sb.append("]");
        return sb.toString();
    }
}
