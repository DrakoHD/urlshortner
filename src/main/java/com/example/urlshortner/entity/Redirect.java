package com.example.urlshortner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
public class Redirect {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @JsonIgnore
    private Long id;

    @Setter
    @Getter
    @NaturalId
    @Column(unique = true, nullable = false)
    private String alias;

    @Setter
    @Getter
    @Column(nullable = false)
    private String url;

    public Redirect() {
    }

    public Redirect(final String alias, final String url) {
        this.alias = alias;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Redirect{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
