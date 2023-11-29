package net.atos.proyecto_atos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dates", nullable = false)
    private Instant dates;

    @Column(name = "labels", nullable = false)
    private String labels;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private List<Project> idProject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_article")
    private List<Article> idArticle;

}