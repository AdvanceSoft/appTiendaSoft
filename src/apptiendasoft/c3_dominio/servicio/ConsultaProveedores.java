/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptiendasoft.c3_dominio.servicio;

import apptiendasoft.c3_dominio.entidad.Proveedor;
import java.util.List;

/**
 *
 * @author
 * <AdvanceSoft - Mendoza Torres, Valentin - advancesoft.trujillo@gmail.com>
 */
public class ConsultaProveedores {
    List<Proveedor> proveedores; 

    public ConsultaProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
    
    public int cantidadProveedoresConsultados(){
        return proveedores.size();
    }
    
    public int cantidadProveedoresActivos(){
        int cantidad=0; 
        for(Proveedor proveedor : proveedores){
            if(proveedor.isActivo())
                cantidad++;
        }
        return cantidad;
    }
    
    public int cantidadProveedoresInactivos(){
        int cantidad=0;
        for(Proveedor proveedor : proveedores){
            if(!proveedor.isActivo())
                cantidad++;
        }
        return cantidad;
    }
}
