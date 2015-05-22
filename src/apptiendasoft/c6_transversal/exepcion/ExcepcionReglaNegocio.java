/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c6_transversal.exepcion;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class ExcepcionReglaNegocio extends Exception{
    private static final String MENSAJE_STOCKINGRESADOINCORRECTO = "El valor del stock ingresado es incorrecto.";
    private static final String MENSAJE_CANTIDADSUPERIORALSTOCK = "La cantidad es superior al stock.";
    private static final String MENSAJE_PEDIDOINCORRECTO = "El pedido es incorrecto, el monto debe ser mayor a cero.";
    private static final String MENSAJE_PRODUCTOYAEXISTE = "El producto ya fue agregado.";
    private static final String MENSAJE_PRODUCTONOCREADO = "El producto no fue creado.";
  
    private ExcepcionReglaNegocio(String message) {
        super(message);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_STOCKINGRESADOINCORRECTO(){
        return new ExcepcionReglaNegocio(MENSAJE_STOCKINGRESADOINCORRECTO);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_CANTIDADSUPERIORALSTOCK(){
        return new ExcepcionReglaNegocio(MENSAJE_CANTIDADSUPERIORALSTOCK);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_PEDIDOINCORRECTO(){
        return new ExcepcionReglaNegocio(MENSAJE_PEDIDOINCORRECTO);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_PRODUCTOYAEXISTE(){
        return new ExcepcionReglaNegocio(MENSAJE_PRODUCTOYAEXISTE);
    }
    
    public static ExcepcionReglaNegocio crearErrorMENSAJE_PRODUCTONOCREADO(){
        return new ExcepcionReglaNegocio(MENSAJE_PRODUCTONOCREADO);
    }
       
}
