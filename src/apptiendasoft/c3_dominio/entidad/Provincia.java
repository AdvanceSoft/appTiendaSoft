/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

/**
 *
 * @author sandra
 */
public class Provincia {
    private int codigo;
    private String nombre;
    private Distrito distrito;

    public Provincia() {
    }

    public Provincia(int codigo, String nombre, Distrito distrito) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.distrito = distrito;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
}
