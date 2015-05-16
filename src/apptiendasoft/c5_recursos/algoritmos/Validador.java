/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c5_recursos.algoritmos;

import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class Validador {
    private static final int APELLIDO_MAX = 3;
    private static final int NOMBRE_MAX = 5;
    
    public static void validarApellido(String apellido)throws Exception{
        String apellidoArray[] = apellido.split(" ");
        int contador=0;
        for (String palbra : apellidoArray){
             contador++;
        }
        if(contador > APELLIDO_MAX)
            throw ExcepcionRegla.crearErrorMENSAJE_APELLIDO();
    }
    public static void validarNombre(String nombre)throws Exception{
        String apellidoArray[] = nombre.split(" ");
        int contador=0;
        for (String palbra : apellidoArray){
             contador++;
        }
        if(contador > NOMBRE_MAX)
            throw ExcepcionRegla.crearErrorMENSAJE_NOMBRE();
    }
    public static void validarCorreo(String correo)throws Exception{
        if(!correo.contains("@") || !correo.contains("."))
            throw ExcepcionRegla.crearErrorMENSAJE_CORREO(); 
    }
}
