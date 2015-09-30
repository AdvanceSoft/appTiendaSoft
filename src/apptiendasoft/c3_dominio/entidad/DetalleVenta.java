/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

/**
 *
 * @author HacybeykerS
 */
public class DetalleVenta {
    private int cantidad;
    private Lote lote;
    private double precio;

    public DetalleVenta(int cantidad, Lote lote, double precio) {
        this.cantidad = cantidad;
        this.lote = lote;
        this.precio = precio;
    }

    public DetalleVenta() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double importe(){
        return precio*cantidad;
    }

}
