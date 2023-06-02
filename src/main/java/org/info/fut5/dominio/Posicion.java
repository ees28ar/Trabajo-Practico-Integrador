package org.info.fut5.dominio;

public class Posicion implements Comparable<Posicion> {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Posicion otraPosicion) {
        return nombre.compareTo(otraPosicion.getNombre());
    }
}

