package net.atos.proyecto_atos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "abstracts", nullable = false)
    private String abstracts;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "titles", nullable = false)
    private String titles;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_blog", nullable = false)
    private Blog blog;

    @ManyToMany(mappedBy = "idArticle")
    private Set<Tag> tags = new LinkedHashSet<>();

}