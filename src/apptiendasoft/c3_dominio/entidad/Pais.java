/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
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
        this.codigo = 0;
        listaDepartamento = new ArrayList();
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
    public void agregarDepartamentos(Departamento departamento) throws Exception{
        if(departamento.getCodigo()!=0){
            verificarExistencia(departamento);
            listaDepartamento.add(departamento);
        }else{
            listaDepartamento.add(departamento);
        }
    }
    private void verificarExistencia(Departamento departamento)throws Exception{
        for(Departamento departamentobuscar : listaDepartamento){
            if(departamentobuscar.getCodigo()==departamento.getCodigo())
                throw new Exception("Ya existe este registro");
        }
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
