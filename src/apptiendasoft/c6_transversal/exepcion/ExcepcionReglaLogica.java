/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c6_transversal.exepcion;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class ExcepcionReglaLogica extends Exception {
    private static final String MENSAJE_USUARIOSINACCESO = "Usuario no permitido.";
    private static final String MENSAJE_ERROR_APELLIDO=  "El apellido ingresado no es valido.";
    private static final String MENSAJE_ERROR_NOMBRE = "El nombre ingresado no es valido.";
    private static final String Mensaje_ERROR_CORREO= "El correo ingresado no es valido.";
    private static final String MENSAJE_ERROR_RUC= "El ruc ingresado no es valido.";
    private static final String MENSAJE_ERROR_UNIDAD_MEDIDA = "La abreviatura para esta unidad de medida no es valida.";
    private static final String MENSAJE_ERROR_PRECIOPRODUCTO = "El precio del producto es invalido"; 
    
    private ExcepcionReglaLogica(String message) {
        super(message);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_USUARIOSINACCESO(){
        return new ExcepcionReglaLogica(MENSAJE_USUARIOSINACCESO);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_APELLIDO(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_APELLIDO);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_NOMBRE(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_NOMBRE);
    }
    public static ExcepcionReglaLogica crearErrorMENSAJE_CORREO(){
        return new ExcepcionReglaLogica(Mensaje_ERROR_CORREO);
    }
    public static ExcepcionReglaLogica crearErrorMENSAJE_RUC(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_RUC);
    }
    public static ExcepcionReglaLogica crearErrorMENSAJE_UNIDADMEDIDAD(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_UNIDAD_MEDIDA);
    }
    
    public static ExcepcionReglaLogica crearErrorMENSAJE_PRECIOPRODUCTO(){
        return new ExcepcionReglaLogica(MENSAJE_ERROR_PRECIOPRODUCTO);
    }
    
    
}
