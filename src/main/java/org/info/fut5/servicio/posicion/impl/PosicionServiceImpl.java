package org.info.fut5.servicio.posicion.impl;

import org.info.fut5.dominio.Posicion;
import org.info.fut5.servicio.entrada.console.Inputservice;
import org.info.fut5.servicio.posicion.PosicionService;





public class PosicionServiceImpl implements PosicionService {

    @Override
    public Posicion establecerPosicion() {
        Posicion nuevaPosicion = new Posicion();
        System.out.println("Introduzca el Número Correspondiente a la Posicion del jugador: ");
        System.out.println("(1) ARQUERO - (2) DEFENSOR - (3) MEDIOCAMPISTA - (4) DELANTERO");
        int pos = Inputservice.getScanner().nextInt();

        switch(pos){
            case 1:
                nuevaPosicion.setNombre("ARQUERO");
                break;
            case 2:
                nuevaPosicion.setNombre("DEFENSOR");
                break;
            case 3:
                nuevaPosicion.setNombre("MEDIOCAMPISTA");
                break;
            case 4:
                nuevaPosicion.setNombre("DELANTERO");
                break;
            default:
                System.out.println("NÚmero Ingresado no Válido");
        }
        return nuevaPosicion;
    }

    @Override
    public Posicion getNombre(String nombre) {
        Posicion posicion = new Posicion();
        posicion.setNombre(nombre);
        return posicion;
    }

}




