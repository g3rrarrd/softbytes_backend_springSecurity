package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.userType;

public interface userTypeService {
    
    /*
     * 0 -> cliente
     * 1 -> membresia
     * 2 -> repartidor
     * 3 -> Administrador
     */

     //obtiene todos los tipos de clientes del comercio
     public List<userType> obtenerTiposUsuarios();

}
