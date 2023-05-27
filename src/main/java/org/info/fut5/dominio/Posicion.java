package org.info.fut5.dominio;

public class Posicion {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Posicion [nombre=" + nombre + "]";
    }

}
