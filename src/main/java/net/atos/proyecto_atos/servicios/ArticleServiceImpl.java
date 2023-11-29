package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.ArticleDTO;
import net.atos.proyecto_atos.entidades.Article;
import net.atos.proyecto_atos.entidades.Blog;
import net.atos.proyecto_atos.excepciones.BlogAppException;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.ArticleMapper;
import net.atos.proyecto_atos.repositorios.ArticleRepository;
import net.atos.proyecto_atos.repositorios.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public ArticleDTO crearArticulo(long blogId, ArticleDTO articleDTO) {

        Article article = articleMapper.toEntity(articleDTO);

        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", blogId));
        article.setBlog(blog);

        Article newArticle = articleRepository.save(article);
        return articleMapper.toDto(newArticle);
    }

    @Override
    public List<ArticleDTO> getTodosArticulos(long blogId) {

        List<Article> articleList = articleRepository.findByBlogId(blogId);
        return articleList.stream().map(articleMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ArticleDTO getArticulo(long blogId, long articuloId) {

        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));
        Article article = articleRepository.findById(articuloId).orElseThrow(() -> new ResourceNotFoundException("Articulo", "ID", articuloId));

        if (!article.getBlog().getId().equals(blog.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El artículo no pertenece al blog");
        }

        return articleMapper.toDto(article);
    }

    @Override
    public ArticleDTO actualizarArticulo(ArticleDTO articleDTO, long blogId, long articuloId) {

        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));
        Article article = articleRepository.findById(articuloId).orElseThrow(() -> new ResourceNotFoundException("Articulo", "ID", articuloId));

        if (!article.getBlog().getId().equals(blog.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El artículo no pertenece al blog");
        }

        article.setAbstracts(articleDTO.getAbstracts());
        article.setContents(articleDTO.getContents());
        article.setTitles(articleDTO.getTitles());

        Article actArticle = articleRepository.save(article);
        return articleMapper.toDto(actArticle);
    }

    @Override
    public void eliminarArticulo(long blogId, long articuloId) {

        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));
        Article article = articleRepository.findById(articuloId).orElseThrow(() -> new ResourceNotFoundException("Articulo", "ID", articuloId));

        if (!article.getBlog().getId().equals(blog.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El artículo no pertenece al blog");
        }

        articleRepository.delete(article);
    }
}
