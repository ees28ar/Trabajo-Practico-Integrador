package org.info.fut5.servicio.entrenador.impl;

import org.info.fut5.dominio.Entrenador;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.entrenador.EntrenadorService;

public class EntrenadorServiceImpl implements EntrenadorService {


    @Override
    public Entrenador crearEntrenador() {

        Entrenador entrenadorNuevo = new Entrenador();
        System.out.println("INGRESE EL NOMBRE DEL ENTRENADOR : ");
        entrenadorNuevo.setNombre(Inputservice.getScanner().nextLine());
        System.out.println("INGRESE EL APELLIDO DEL ENTRENADOR : ");
        entrenadorNuevo.setApellido(Inputservice.getScanner().nextLine());
        System.out.println("INGRESE LA EDAD DEL ENTRENADOR : ");
        entrenadorNuevo.setEdad(Inputservice.getScanner().nextInt());
        return entrenadorNuevo;
    }

}

