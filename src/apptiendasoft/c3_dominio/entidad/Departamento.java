/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandra
 */
public class Departamento {
    private int codigo;
    private String nombre;
    List<Provincia> listaProvincia;

    public Departamento() {
        listaProvincia = new ArrayList();
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

    public List<Provincia> getListaProvincia() {
        return listaProvincia;
    }

    public void agregarProvincias(Provincia provincia){
        //antes de agregar si hay una validacion tiene que ir aquí
        listaProvincia.add(provincia);
    }
    
    public int cantidadDeProvincias(){
        return listaProvincia.size();
    }
    
    public void eliminarProvincia(Provincia provincia){
        for(Provincia provinciaeliminar : listaProvincia){
            if(provinciaeliminar.getNombre().equals(provincia.getNombre())){
                listaProvincia.remove(provinciaeliminar);
                break;
            }
        }
    }
}
