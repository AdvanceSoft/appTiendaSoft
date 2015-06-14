/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.entidad;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * <AdvanceSoft - Medrano Parado Sandra Zoraida - advancesoft.trujillo@gmail.com>
 */
public class Departamento {
    private int codigo;
    private String nombre;
    List<Provincia> listaProvincia;

    public Departamento() {
        this.codigo = 0;
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

    public void agregarProvincias(Provincia provincia) throws Exception{
        if(provincia.getCodigo()!=0){
            verificarProvincia(provincia);
            listaProvincia.add(provincia);
        }else{
            listaProvincia.add(provincia);
        }
    }
    public void verificarProvincia(Provincia provincia) throws Exception{
        for (Provincia provinciabuscar : listaProvincia) {
            if(provinciabuscar.getCodigo()==provincia.getCodigo()){
                throw new Exception("Ya existe el registro");
            }
        }
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
