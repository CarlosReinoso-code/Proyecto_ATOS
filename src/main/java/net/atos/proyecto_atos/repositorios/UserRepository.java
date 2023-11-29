package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}