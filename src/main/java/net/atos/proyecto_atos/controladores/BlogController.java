package net.atos.proyecto_atos.controladores;

import net.atos.proyecto_atos.dto.BlogDTO;
import net.atos.proyecto_atos.servicios.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/usuarios/{idUser}/blogs")
    public ResponseEntity<BlogDTO> saveBlog(@Valid @RequestBody BlogDTO blogDTO, @PathVariable(name = "idUser") long idUser) {
        return new ResponseEntity<>(blogService.crearBlog(idUser, blogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios/{idUser}/blogs")
    public List<BlogDTO> listBlogs(@PathVariable(name = "idUser") long idUser) {
        return blogService.getTodosBlogs(idUser);
    }

    @GetMapping("/usuarios/{idUser}/blogs/{idBlog}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable(name = "idUser") long idUser, @PathVariable(name = "idBlog") long idBlog) {
        return ResponseEntity.ok(blogService.getBlog(idUser, idBlog));
    }

    @PutMapping("/usuarios/{idUser}/blogs/{idBlog}")
    public ResponseEntity<BlogDTO> setBlog(@Valid @RequestBody BlogDTO blogDTO, @PathVariable(name = "idUser") long idUser, @PathVariable(name = "idBlog") long idBlog) {
        BlogDTO response = blogService.actualizarBlog(blogDTO, idUser, idBlog);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{idUser}/blogs/{idBlog}")
    public ResponseEntity<String> deleteBlog(@PathVariable(name = "idUser") long idUser, @PathVariable(name = "idBlog") long idBlog) {
        blogService.eliminarBlog(idUser, idBlog);
        return new ResponseEntity<>("Blog eliminado correctamente", HttpStatus.OK);
    }
}
