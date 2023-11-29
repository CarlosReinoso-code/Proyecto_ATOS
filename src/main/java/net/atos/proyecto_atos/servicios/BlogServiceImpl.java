package net.atos.proyecto_atos.servicios;

import net.atos.proyecto_atos.dto.BlogDTO;
import net.atos.proyecto_atos.entidades.Blog;
import net.atos.proyecto_atos.entidades.User;
import net.atos.proyecto_atos.excepciones.BlogAppException;
import net.atos.proyecto_atos.excepciones.ResourceNotFoundException;
import net.atos.proyecto_atos.mappers.BlogMapper;
import net.atos.proyecto_atos.mappers.BlogMapperImpl;
import net.atos.proyecto_atos.repositorios.BlogRepository;
import net.atos.proyecto_atos.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BlogDTO crearBlog(long userId, BlogDTO blogDTO) {

        Blog blog = blogMapper.toEntity(blogDTO);

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        blog.setUser(user);

        Blog newBlog = blogRepository.save(blog);
        return blogMapper.toDto(newBlog);
    }

    @Override
    public List<BlogDTO> getTodosBlogs(long userId) {

        List<Blog> blogList = blogRepository.findByUserId(userId);
        return blogList.stream().map(blogMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BlogDTO getBlog(long userId, long blogId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", userId));
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));

        if (!blog.getUser().getId().equals(user.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El blog no pertenece al usuario");
        }

        return blogMapper.toDto(blog);
    }

    @Override
    public BlogDTO actualizarBlog(BlogDTO blogDTO, long userId, long blogId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", userId));
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));

        if (!blog.getUser().getId().equals(user.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El blog no pertenece al usuario");
        }

        blog.setDate(Instant.now());
        blog.setTitle(blogDTO.getTitle());

        Blog actBlog = blogRepository.save(blog);
        return blogMapper.toDto(actBlog);
    }

    @Override
    public void eliminarBlog(long userId, long blogId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", userId));
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new ResourceNotFoundException("Blog", "ID", blogId));

        if (!blog.getUser().getId().equals(user.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El blog no pertenece al usuario");
        }

        blogRepository.delete(blog);
    }
}
