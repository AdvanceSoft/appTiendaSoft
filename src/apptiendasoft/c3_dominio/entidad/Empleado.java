/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import java.util.Date;

/**
 *
 * @author 
 *  <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class Empleado extends Persona{
    
    private Date fechaIngreso;
    private Date fechaSalida;
    private double sueldo;
    private Cargo cargo;
    private Usuario usuario;
    
    public Empleado( ) {
        
    }

    public Empleado(int codigo, String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo, String sexo, boolean activo, Pais pais,Departamento departamento, Provincia provincia,Distrito distrito, Date fechaIngreso, Date fechaSalida, double sueldo, Cargo cargo, Usuario usuario) {
        super(codigo, nombre, apellido, dni, direccion, telefono, celular, correo, sexo, activo,pais, departamento, provincia, distrito );
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.usuario = usuario;
    }    

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
