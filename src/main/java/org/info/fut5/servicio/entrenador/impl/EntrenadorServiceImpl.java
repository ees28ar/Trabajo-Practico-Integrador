package org.info.fut5.servicio.entrenador.impl;

import org.info.fut5.dominio.Entrenador;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.entrenador.EntrenadorService;

import java.util.InputMismatchException;

import static org.info.fut5.servicio.entrada.console.Inputservice.scanner;

public class EntrenadorServiceImpl implements EntrenadorService {


    @Override
    public Entrenador crearEntrenador() {

        Entrenador entrenadorNuevo = new Entrenador();
       // System.out.println("INGRESE EL NOMBRE DEL ENTRENADOR : ");

        String nombreEntrenador = "";
        do {
            System.out.print("INGRESE EL NOMBRE DEL ENTRENADOR : ");
            try {
                if (scanner.hasNextInt()) {
                    throw new InputMismatchException("Se esperaba un valor de tipo String, no un entero");
                }
                nombreEntrenador = Inputservice.getScanner().nextLine();

                entrenadorNuevo.setNombre(nombreEntrenador);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        } while (nombreEntrenador.isEmpty());

       // entrenadorNuevo.setNombre(Inputservice.getScanner().nextLine());

        String apellidoEntrenador = "";
        do {
            System.out.print("INGRESE EL APELLIDO DEL ENTRENADOR : ");
            try {
                if (scanner.hasNextInt()) {
                    throw new InputMismatchException("Se esperaba un valor de tipo String, no un entero");
                }
                apellidoEntrenador = Inputservice.getScanner().nextLine();

                entrenadorNuevo.setNombre(nombreEntrenador);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        } while (apellidoEntrenador.isEmpty());

        //System.out.println("INGRESE EL APELLIDO DEL ENTRENADOR : ");
        //entrenadorNuevo.setApellido(Inputservice.getScanner().nextLine());

        int edadEntrenador = 0;
        do {
            System.out.print("INGRESE LA EDAD DEL ENTRENADOR : ");
            try {
                edadEntrenador = Inputservice.getScanner().nextInt();
                entrenadorNuevo.setEdad(edadEntrenador);
            } catch (InputMismatchException e) {
                System.out.println("Error: Se esperaba un valor de tipo entero.");
                scanner.nextLine();
            }
        } while (edadEntrenador <= 0);

        // System.out.println("INGRESE LA EDAD DEL ENTRENADOR : ");
        //entrenadorNuevo.setEdad(Inputservice.getScanner().nextInt());
        return entrenadorNuevo;
    }

}

