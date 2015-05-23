/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;



/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class UnidadDeMedida {
    private int codigoUnidadDeMedida;
    private String nombreUnidadDeMedida;
    private String descripcionUnidadDeMedida;

    public UnidadDeMedida() {
        this.codigoUnidadDeMedida = 0;
    }
    
    public int getCodigoUnidadDeMedida() {
        return codigoUnidadDeMedida;
    }

    public void setCodigoUnidadDeMedida(int codigoUnidadDeMedida) {
        this.codigoUnidadDeMedida = codigoUnidadDeMedida;
    }

    public String getNombreUnidadDeMedida() {
        return nombreUnidadDeMedida;
    }

    public void setNombreUnidadDeMedida(String nombreUnidadDeMedida){
        this.nombreUnidadDeMedida=nombreUnidadDeMedida;
    }
   
    public String getDescripcionUnidadDeMedida() {
        return descripcionUnidadDeMedida;
    }

    public void setDescripcionUnidadDeMedida(String descripcionUnidadDeMedida) {
      this.descripcionUnidadDeMedida= descripcionUnidadDeMedida;
    }
    
    
}
