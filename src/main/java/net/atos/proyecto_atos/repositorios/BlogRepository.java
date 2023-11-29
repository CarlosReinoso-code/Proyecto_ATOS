package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByUserId(long userId);
}