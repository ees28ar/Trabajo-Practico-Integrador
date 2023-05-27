package org.info.fut5.dominio;

public class Entrenador {
    private String nombre;
    private String apellido;
    private int edad;


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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Entrenador [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
    }
}
