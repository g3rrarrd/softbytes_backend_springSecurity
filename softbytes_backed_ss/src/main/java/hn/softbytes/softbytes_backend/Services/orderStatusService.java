package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.orderStatus;

public interface orderStatusService {

    public List<orderStatus> obtenerOrdenEstado();

    public List<orderStatus> obtenerPorEstado(String estado);
    
}
