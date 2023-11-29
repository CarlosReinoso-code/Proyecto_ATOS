package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByBlogId(long blogId);
}