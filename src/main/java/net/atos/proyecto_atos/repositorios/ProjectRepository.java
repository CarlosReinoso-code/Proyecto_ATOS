package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}