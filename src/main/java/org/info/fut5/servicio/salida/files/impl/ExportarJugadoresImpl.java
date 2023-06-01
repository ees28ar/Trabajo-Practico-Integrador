package org.info.fut5.servicio.salida.files.impl;

import org.info.fut5.dominio.Jugador;
import org.info.fut5.servicio.salida.files.ExportarJugadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportarJugadoresImpl implements ExportarJugadores {
    @Override
    public void exportarJugadores(List<Jugador> jugadores, String nombreEquipo, String nombreEntrenador, String rutaDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDestino))) {
            writer.write("Nombre del Equipo: " + nombreEquipo);
            writer.newLine();
            writer.write("Nombre del Entrenador: " + nombreEntrenador);
            writer.newLine();
            writer.newLine(); // Agregar una línea en blanco antes de la lista de jugadores

            for (Jugador jugador : jugadores) {
                writer.write(jugador.toString());  // Escribe la representación del jugador en el archivo
                writer.newLine();  // Agrega una nueva línea después de cada jugador
            }

            System.out.println("Los jugadores se han exportado correctamente al archivo: " + rutaDestino);
        } catch (IOException e) {
            System.out.println("Error al exportar los jugadores al archivo: " + rutaDestino);
            e.printStackTrace();
        }
    }
}
