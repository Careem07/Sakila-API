package org.iti.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @Size(max = 25)
    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "category")
    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<FilmCategory> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }

}