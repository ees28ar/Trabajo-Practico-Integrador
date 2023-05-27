package org.info.fut5;

import org.info.fut5.servicio.entrada.MenuEntrada.MenuEntradaService;
import org.info.fut5.servicio.entrada.MenuEntrada.impl.MenuEntradaServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MenuEntradaService mostrarMenuEntrada =new MenuEntradaServiceImpl();

        mostrarMenuEntrada.mostrarMenuEntrada();

    }
    }

