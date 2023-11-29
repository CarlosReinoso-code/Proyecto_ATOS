package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.DetailDTO;

import java.util.List;

public interface DetailService {
    DetailDTO crearDetalle(DetailDTO detailDTO);

    List<DetailDTO> getTodosDetalles();

    DetailDTO getDetalle(long id);

    DetailDTO actualizarDetalle(DetailDTO detailDTO, long id);

    void eliminarDetalle(long id);
}
