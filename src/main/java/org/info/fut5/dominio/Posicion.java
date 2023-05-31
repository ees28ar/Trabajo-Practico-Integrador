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
        return "Posicion [nombre=" + nombre + "]";
    }

    @Override
    public int compareTo(Posicion otraPosicion) {
        // Implementa la lógica de comparación según tus necesidades
        // Por ejemplo, si las posiciones son Strings, puedes usar el método compareTo de String
        return nombre.compareTo(otraPosicion.getNombre());
    }
}

