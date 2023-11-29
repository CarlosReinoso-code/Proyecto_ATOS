package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    BlogDTO crearBlog(long userId, BlogDTO blogDTO);

    List<BlogDTO> getTodosBlogs(long userId);

    BlogDTO getBlog(long userId, long blogId);

    BlogDTO actualizarBlog(BlogDTO blogDTO, long userId, long blogId);

    void eliminarBlog(long userId, long blogId);
}
