/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author HacybeykerS
 */
public class Venta {
    private int codigo;
    private double descuento;
    private Date fechaventa;
    private List<DetalleVenta> listadetalleventa;
    private Empleado empleado;
    private Cliente cliente;

    public Venta() {
        codigo=0;
        listadetalleventa = new ArrayList<>();
    }

    public Venta(int codigo, double descuento, Date fechaventa, List<DetalleVenta> listadetalleventa, Empleado empleado, Cliente cliente) {
        this.codigo = codigo;
        this.descuento = descuento;
        this.fechaventa = fechaventa;
        this.listadetalleventa = listadetalleventa;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public List<DetalleVenta> getListadetalleventa() {
        return listadetalleventa;
    }

    public void setListadetalleventa(List<DetalleVenta> listadetalleventa) {
        this.listadetalleventa = listadetalleventa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void productoRepetir(Producto producto) throws Exception{
        for(DetalleVenta detalleVenta : listadetalleventa){
            if(detalleVenta.getLote().getProducto().getCodigo()==producto.getCodigo()){
                throw ExcepcionRegla.crearErrorMENSAJE_PRODUCTOYAEXISTE();
            }
        }
    }
    public double descuento(){
        return 0.0;
    }
    public double subTotal(){
        double subtotal = 0;
        for(DetalleVenta detalleVenta: listadetalleventa){
            subtotal+=detalleVenta.importe();
        }
        return subtotal;
    }
    public double total(){
        return subTotal()-descuento();
    }
    public void verificarTotal() throws Exception{
        if(total()<=0){
            throw ExcepcionRegla.crearErrorMENSAJE_PEDIDOINCORRECTO();
        }
    }
}
