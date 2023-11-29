package net.atos.proyecto_atos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "open", nullable = false)
    private Boolean open = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private List<User> idUser;

}