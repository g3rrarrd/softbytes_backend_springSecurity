package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.address;

public interface addressService {
    
    /*
     * Creara una direccion en la tabla direcciones
     * @param address address:Json
     * @return boolean
     */
    public boolean crearDireccion(int idCliente,int idCiudad, address address);

    /*
     * Se buscara una direccion segun su id
     * @param id idAddress
     * @return address
     */
    public address buscarDireccion(int id);

    /*
     * Obtendra todas las direcciones en la tabla
     * @return Lsit<address>
     */
    public List<address> obtenerDireciones();

    /*
     * Actualizara los valores en la tabla direccion segun la id
     * @param id idAddress
     * @param address address:Json
     * @return boolean
     */
    public boolean actualizarDireccion(int id, address address);

    public boolean eliminarDireccion(int id);

    public List<address> obtenerDireccionesCliente(int id);
}
