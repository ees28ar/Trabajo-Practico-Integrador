package org.info.fut5.servicio.salida.files.impl;

import org.info.fut5.dominio.Equipo;
import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.salida.files.OutPutFileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutPutFileServiceImpl implements OutPutFileService {
    @Override
    public void exportJugadores(List<Equipo> equipos, String rutaDeDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))){
            for (Equipo equipo : equipos){
                for (Jugador jugador : equipo.getJugadores()) {
                    String linea = jugador.getNombre() + ";" +
                            jugador.getApellido() + ":" +
                            jugador.getAltura() + ";" +
                            jugador.isEsCapitan() + ";" +
                            jugador.getPosicion().getNombre() + ";" +
                            jugador.getCantidadGoles() + ";" +
                            jugador.getCantidadPartidosJugados() + ";" +
                            jugador.getId() + ";" +
                            jugador.getNumeroCamiseta() + ";" +
                            jugador.getEquipo().getNombre() + ";" +
                            jugador.getEquipo().getEntrenador().getNombre();
                    writer.write(linea);
                    writer.newLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
