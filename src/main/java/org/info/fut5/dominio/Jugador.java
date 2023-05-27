package org.info.fut5.dominio;

import java.util.UUID;

public class Jugador {
    private UUID id;
    private String nombre;
    private String apellido;
    private double altura;
    private Posicion posicion;
    private int cantidadGoles;
    private int cantidadPartidosJugados;
    private boolean esCapitan;
    private int numeroCamiseta;
    private Equipo equipo;



    public Jugador(UUID id, String nombre, String apellido, double altura, Posicion posicion, int cantidadGoles,
                   int cantidadPartidosJugados, boolean esCapitan, int numeroCamiseta, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.posicion = posicion;
        this.cantidadGoles = cantidadGoles;
        this.cantidadPartidosJugados = cantidadPartidosJugados;
        this.esCapitan = esCapitan;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    public int getCantidadGoles() {
        return cantidadGoles;
    }
    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }
    public int getCantidadPartidosJugados() {
        return cantidadPartidosJugados;
    }
    public void setCantidadPartidosJugados(int cantidadPartidosJugados) {
        this.cantidadPartidosJugados = cantidadPartidosJugados;
    }


    public boolean isEsCapitan() {
        return esCapitan;
    }
    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }
    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }
    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    @Override
    public String toString() {
        return "Jugador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", altura=" + altura
                + ", posicion=" + posicion + ", cantidadGoles=" + cantidadGoles + ", cantidadPartidosJugados="
                + cantidadPartidosJugados + ", esCapitan=" + esCapitan + ", numeroCamiseta=" + numeroCamiseta
                + "]";
    }
}
