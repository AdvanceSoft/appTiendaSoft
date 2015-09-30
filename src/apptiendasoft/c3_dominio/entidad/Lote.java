/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;
import java.util.Date;

/**
 *
 * @author HacybeykerS
 */
public class Lote {
    private int cantidadlote;
    private int codigo;
    private Date fechavencimiento;
    private Producto producto;

    public Lote() {
        codigo=0;
    }

    public Lote(int cantidadlote, int codigo, Date fechavencimiento, Producto producto) {
        this.cantidadlote = cantidadlote;
        this.codigo = codigo;
        this.fechavencimiento = fechavencimiento;
        this.producto = producto;
    }
    
    public int getCantidadlote() {
        return cantidadlote;
    }

    public void setCantidadlote(int cantidadlote) {
        this.cantidadlote = cantidadlote;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void verificarStock() throws Exception{
        if(this.cantidadlote<=0)
            throw ExcepcionRegla.crearErrorMENSAJE_VERIFICACIONSTOCK();
    }
    
    public void compararStock(int cantidad)throws Exception{
        if(this.cantidadlote<cantidad)
            throw  ExcepcionRegla.crearErrorMENSAJE_CANTIDADSUPERIORALSTOCK();
    }
    public void actualizarStock(int cantidad){
        cantidadlote=cantidadlote-cantidad;
    }
}
