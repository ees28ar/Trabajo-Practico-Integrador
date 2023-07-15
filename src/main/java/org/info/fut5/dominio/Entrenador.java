package org.info.fut5.dominio;

public class Entrenador extends Persona {
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Entrenador [nombre=" + getNombre() + ", apellido=" + getApellido() + ", edad=" + edad + "]";
    }
}