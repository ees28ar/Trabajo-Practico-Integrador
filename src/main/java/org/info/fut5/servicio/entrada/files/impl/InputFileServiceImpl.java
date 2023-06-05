package org.info.fut5.servicio.entrada.files.impl;

import org.apache.commons.io.FileUtils;
import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.dominio.Posicion;
import org.info.fut5.servicio.entrada.files.InputFileService;
import org.info.fut5.servicio.posicion.PosicionService;
import org.info.fut5.servicio.posicion.impl.PosicionServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InputFileServiceImpl implements InputFileService {
    private final PosicionService posicionService = new PosicionServiceImpl();

    @Override
    public List<Jugador> LoadJugadorByFile(String rutaArchivo, Equipo equipo) {
        List<Jugador> jugador = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + rutaArchivo);
        }
        try {
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);

            for (String linea : lineas) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];
                String altura = partes[2];
                Integer alturaJugador = Integer.parseInt(altura.trim());
                String posicionNombre = partes[3];
                String goles = partes[4];
                Integer golesConvertidos = Integer.parseInt(goles.trim());
                String partidos = partes[5];
                Integer partidosJugador = Integer.parseInt(partidos.trim());
                String isCapitan = partes[6];
                //Boolean isCapitanJugador = (isCapitan.equalsIgnoreCase("no")) ? true : false;
                //Boolean isCapitanJugador= false;
                /*if (isCapitan.equalsIgnoreCase("si")){
                     isCapitanJugador=true;
                };*/
                Boolean isCapitanJugador = (isCapitan.equalsIgnoreCase("si"));
                String camiseta = partes[7];
                Integer camisetaJugador = Integer.parseInt(camiseta.trim());

                Posicion posicion = posicionService.getNombre(posicionNombre);
                UUID idJugador = UUID.randomUUID();

                Jugador jugadorNuevo = new Jugador(idJugador, nombre, apellido, alturaJugador, posicion, golesConvertidos,
                        partidosJugador, isCapitanJugador, camisetaJugador, equipo);
                jugador.add(jugadorNuevo);

                System.out.println(isCapitan);
                System.out.println(isCapitan.getClass().getSimpleName());
                System.out.println(isCapitanJugador);
            }
        } catch (IOException e) {

            System.out.println("Error al importar los jugadores del archivo: " + rutaArchivo);
            e.printStackTrace();
        }
        return jugador;
    }

}

