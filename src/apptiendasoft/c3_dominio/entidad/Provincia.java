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
public class Provincia {
    private int codigo;
    private String nombre;
    List<Distrito> listadistrito;

    public Provincia() {
        listadistrito = new ArrayList();
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

    public List<Distrito> getListadistrito() {
        return listadistrito;
    }
    public void agregarDistrito(Distrito distrito)throws Exception{
        verificarExistencia(distrito);
        listadistrito.add(distrito);
    }
    public void agregardistrito(Distrito distrito){
        listadistrito.add(distrito);
    }
    public int cantidadDistritos(){
        return listadistrito.size();
    }
    private void verificarExistencia(Distrito distrito)throws Exception{
        for(Distrito distritoabuscar : listadistrito){
            if(distritoabuscar.getCodigo()==distrito.getCodigo())
                throw new Exception("Ya existe este registro");
        }
    }
    public void eliminarDistrito(Distrito distrito){
        for(Distrito distritoaeliminar : listadistrito){
            if(distritoaeliminar.getCodigo()==distrito.getCodigo()){
                listadistrito.remove(distritoaeliminar);
                break;
            }
        }
    }
    /**
     * Metodos para extraer el distrito de la lista de coleccion de la provincia
     * @param distrito
     * @return 
     */
    public Distrito obtenerDistrito(Distrito distrito){
        for(Distrito distritoobtener : listadistrito){
            if(distritoobtener.getCodigo()==distrito.getCodigo()){
                return distritoobtener;
            }
        }
        return null;
    }
    
}
