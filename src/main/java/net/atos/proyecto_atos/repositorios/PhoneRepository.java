package net.atos.proyecto_atos.repositorios;

import net.atos.proyecto_atos.entidades.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}