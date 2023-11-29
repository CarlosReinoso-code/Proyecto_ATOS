package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}