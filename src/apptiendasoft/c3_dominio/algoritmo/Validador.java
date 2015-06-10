/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.algoritmo;

import apptiendasoft.c6_transversal.exepcion.ExcepcionReglaLogica;



/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class Validador {
    private static final int APELLIDO_MAX = 30;
    private static final int APELLIDO_MIN = 3;
    private static final int PALABRA_APELLIDO_MAX = 4;
    
    private static final int NOMBRE_MAX = 25;
    private static final int NOMBRE_MIN = 2;
    private static final int PALABRA_NOMBRE_MAX = 5;
  
    private static final int NUM_RUC= 11;
    private static final int NUM_MAX_ABREVIATURA = 5;
    
    public static void validarApellido(String apellido)throws Exception{
        String apellidoArray[] = apellido.trim().split(" ");
        int contador=0;        
        for (String palabra : apellidoArray){
            contador++;             
            if(palabra.length()<=APELLIDO_MIN || palabra.length()>=APELLIDO_MAX ||!palabra.matches("[a-zA-Z]*"))
                     throw ExcepcionReglaLogica.crearErrorMENSAJE_APELLIDO();                        
        }
        if(contador>PALABRA_APELLIDO_MAX)
            throw ExcepcionReglaLogica.crearErrorMENSAJE_APELLIDO();
    }
    
    public static void validarNombre(String nombre)throws Exception{
        String nombreArray[] = nombre.trim().split(" ");
        int contador=0;        
        for (String palabra : nombreArray){
            contador++;             
            if(palabra.length()<=NOMBRE_MIN || palabra.length()>=NOMBRE_MAX ||!palabra.matches("[a-zA-Z]*"))
                     throw ExcepcionReglaLogica.crearErrorMENSAJE_NOMBRE();                        
        }
        if(contador>PALABRA_NOMBRE_MAX)
            throw ExcepcionReglaLogica.crearErrorMENSAJE_NOMBRE();
    }
    
    public static void validarCorreo(String correo)throws Exception{
        if(!correo.contains("@") || !correo.contains("."))
            throw ExcepcionReglaLogica.crearErrorMENSAJE_CORREO(); 
    }
    
    public static void validarRuc(String ruc)throws Exception{
        if(ruc.length() > NUM_RUC || ruc.length() < NUM_RUC || !ruc.matches("[0-9]*"))
        throw ExcepcionReglaLogica.crearErrorMENSAJE_RUC();
    }
    
    public static void validarAbreviaturaUnidadDeMedida(String abreviatura)throws Exception{        
        if(abreviatura.trim().length()>NUM_MAX_ABREVIATURA)
            throw ExcepcionReglaLogica.crearErrorMENSAJE_UNIDADMEDIDAD();
    }
}
