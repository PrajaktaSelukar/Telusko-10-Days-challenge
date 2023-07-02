package com.prajakta.ProductSpringWebBitly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlDb extends JpaRepository<URL, Long> {
    public List<URL> findAll();
}
