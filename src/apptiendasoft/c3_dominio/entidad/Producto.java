/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import apptiendasoft.c6_transversal.exepcion.ExcepcionRegla;

/**
 *
 * @author
 * <AdvanceSoft - Osorio Perez Carlos Alfredo - advancesoft.trujillo@gmail.com>
 */
public class Producto {
    private int codigo;
    private String codigobarras;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean estado;

    private Marca marca;
    private UnidadDeMedida unidadDeMedida;
    private TipoProducto tipoProducto;
    
    public Producto() {
        this.codigo = 0;
    }

    public Producto(int codigo, String codigobarras, String nombre, String descripcion, double precio, boolean estado, Marca marca, UnidadDeMedida unidadDeMedida, TipoProducto tipoProducto) {
        this.codigo = codigo;
        this.codigobarras = codigobarras;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.marca = marca;
        this.unidadDeMedida = unidadDeMedida;
        this.tipoProducto = tipoProducto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    public void verificarPrecio() throws ExcepcionRegla{
        if(precio <= 0.0)
            throw ExcepcionRegla.crearErrorMENSAJE_PEDIDOINCORRECTO();
    }
}
