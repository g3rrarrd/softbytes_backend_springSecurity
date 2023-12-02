package hn.softbytes.softbytes_backend.Services;

import java.time.LocalDate;
import java.util.List;

import hn.softbytes.softbytes_backend.Models.newUserJson;
import hn.softbytes.softbytes_backend.Models.users;

public interface usersService {
    
    
    /*
     * Crea un cliente en la base de datos
     * @param users valor tipo json con los atributos del cliente
     * @return boolean, True Exito, False fracaso
     */
    public boolean crearCliente(newUserJson newUserJson);

    /*
     * Modifica un usuario existente
     * @param id Id del usuario a modificar
     * @return boolean, True Exito, False fracaso
     */
    public boolean modificarCliente(int id, users users);

    /*
     * Busca un cliente en la base de datos por medio del correo
     * @param correo Correo del cliente a obtener id
     * @return idCliente 
     */
    public int idCliente(String correo);

    /*
     * elimina un cliente de la base de datos
     * @param id id del cliente que se desea eliminar
     * @return True en caso de que se elimine y False en caso de error
     */
    public boolean eliminarCliente(int id);

    /*
     * Obtiene el cliente por medio de su id
     * @param id id del cliente
     * @return un objeto tipo users
     */
    public users buscarCliente(int id);

    /*
     * obtiene todos los clientes en la base de datos
     * @return Lista de clientes
     */
    public List<users> obtenerTodosClientes();

    /*
     * Obtiene los clientes por tipo usuario
     * @param idTipoUsuario
     * @return Lista de clientes de ese tipo
     */
    public List<users> obtenerClientePorTipo(int id);

    /*
     * Obtiene a los clientes que esten entre dos fechas
     * @param fechaInicio primera fecha
     * @param fechaFinal la fecha limite
     * @return Lista de clientes que hayan nacido entre esos anios
     */
    public List<users> clientePorFecha(LocalDate fechaInicio, LocalDate fechaFinal);

    public boolean isClientValidate(String email, String password);

}
