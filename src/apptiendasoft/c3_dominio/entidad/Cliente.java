/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

/**
 *
 * @author 
 *  <AdvanceSoft - Garcia Infante Petter Jhunior - advancesoft.trujillo@gmail.com>
 */
public class Cliente extends Persona{

    public Cliente()
    {
        
    }
    public Cliente(int codigo, String nombre, String apellido, String dni, String direccion, String telefono, String celular, String correo, String genero, boolean activo, Pais pais, Departamento departamento,Provincia provincia, Distrito distrito) {
       super(codigo, nombre, apellido, dni, direccion, telefono, celular, correo, genero, activo, pais, departamento, provincia, distrito);
    }
}
