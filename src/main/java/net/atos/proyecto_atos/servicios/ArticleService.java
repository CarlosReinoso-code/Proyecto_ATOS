package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO crearArticulo(long blogId, ArticleDTO articleDTO);

    List<ArticleDTO> getTodosArticulos(long blogId);

    ArticleDTO getArticulo(long blogId, long articuloId);

    ArticleDTO actualizarArticulo(ArticleDTO articleDTO, long blogId, long articuloId);

    void eliminarArticulo(long blogId, long articuloId);
}
