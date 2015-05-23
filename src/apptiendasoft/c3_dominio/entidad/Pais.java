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
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class Pais {
    private int codigo;
    private String nombre;
    List<Departamento> listaDepartamento;
    
    public Pais(){
        
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

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }
    public void agregarDepartamentos(Departamento departamento){
        //antes de agregar si hay una validacion tiene que ir aquí
        listaDepartamento.add(departamento);
    }
    
    public int cantidadDeDepartamentos(){
        return listaDepartamento.size();
    }
    
    public void eliminarDepartamento(Departamento departamento){
        for(Departamento departamentoeliminar : listaDepartamento){
            if(departamentoeliminar.getNombre().equals(departamento.getNombre())){
                listaDepartamento.remove(departamentoeliminar);
                break;
            }
        }
    }
    
    
}
