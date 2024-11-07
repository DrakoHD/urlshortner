package com.example.urlshortner.repository;

import com.example.urlshortner.entity.Redirect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RedirectRepository extends JpaRepository<Redirect, Long> {
    Optional<Redirect> findByAlias(String alias);

    Boolean existsByAlias(String alias);
}
