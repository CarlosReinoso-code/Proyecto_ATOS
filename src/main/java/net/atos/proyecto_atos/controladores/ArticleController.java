package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.ArticleDTO;
import net.atos.proyecto_atos.servicios.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/blogs/{idBlog}/articulos")
    public ResponseEntity<ArticleDTO> saveArticle(@Valid @RequestBody ArticleDTO articleDTO, @PathVariable(name = "idBlog") long blogId) {
        return new ResponseEntity<>(articleService.crearArticulo(blogId, articleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{idBlog}/articulos")
    public List<ArticleDTO> listArticles(@PathVariable(name = "idBlog") long blogId) {
        return articleService.getTodosArticulos(blogId);
    }

    @GetMapping("/blogs/{idBlog}/articulos/{idArticulo}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable(name = "idBlog") long idBlog, @PathVariable(name = "idArticulo") long idArticulo) {
        return ResponseEntity.ok(articleService.getArticulo(idBlog, idArticulo));
    }

    @PutMapping("/blogs/{idBlog}/articulos/{idArticulo}")
    public ResponseEntity<ArticleDTO> setArticle(@Valid @RequestBody ArticleDTO articleDTO, @PathVariable(name = "idBlog") long idBlog, @PathVariable(name = "idArticulo") long idArticulo) {
        ArticleDTO response = articleService.actualizarArticulo(articleDTO, idBlog, idArticulo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{idBlog}/articulos/{idArticulo}")
    public ResponseEntity<String> deleteArticle(@PathVariable(name = "idBlog") long idBlog, @PathVariable(name = "idArticulo") long idArticulo) {
        articleService.eliminarArticulo(idBlog, idArticulo);
        return new ResponseEntity<>("Artículo eliminado correctamente", HttpStatus.OK);
    }
}
