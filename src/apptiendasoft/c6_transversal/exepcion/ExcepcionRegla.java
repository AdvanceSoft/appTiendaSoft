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
public class ExcepcionRegla extends Exception{
    private static final String MENSAJE_STOCKINGRESADOINCORRECTO = "El valor del stock ingresado es incorrecto.";
    private static final String MENSAJE_CANTIDADSUPERIORALSTOCK = "La cantidad es superior al stock.";
    private static final String MENSAJE_PEDIDOINCORRECTO = "El pedido es incorrecto, el monto debe ser mayor a cero.";
    private static final String MENSAJE_PRODUCTOYAEXISTE = "El producto ya fue agregado.";
    private static final String MENSAJE_PRODUCTONOCREADO = "El producto no fue creado.";
    private static final String MENSAJE_VERIFICACIONSTOCK = "Stock Insuficiente.";

  
    private ExcepcionRegla(String message) {
        super(message);
    }
    public static ExcepcionRegla crearErrorMENSAJE_STOCKINGRESADOINCORRECTO(){
        return new ExcepcionRegla(MENSAJE_STOCKINGRESADOINCORRECTO);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_VERIFICACIONSTOCK(){
        return new ExcepcionRegla(MENSAJE_VERIFICACIONSTOCK);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_CANTIDADSUPERIORALSTOCK(){
        return new ExcepcionRegla(MENSAJE_CANTIDADSUPERIORALSTOCK);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_PEDIDOINCORRECTO(){
        return new ExcepcionRegla(MENSAJE_PEDIDOINCORRECTO);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_PRODUCTOYAEXISTE(){
        return new ExcepcionRegla(MENSAJE_PRODUCTOYAEXISTE);
    }
    
    public static ExcepcionRegla crearErrorMENSAJE_PRODUCTONOCREADO(){
        return new ExcepcionRegla(MENSAJE_PRODUCTONOCREADO);
    }
}
