package com.selukar.ProductSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//what is orm (Object relation mapping)
@Repository
public interface ProductDB extends JpaRepository<Product, Long> {
    List<Product> findByNameIgnoreCase(String name);
    List<Product> findAll();
    List<Product> findByWarrantyLessThan(Integer warranty);
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:searchText% OR LOWER(p.type) LIKE %:searchText% OR LOWER(p.place) LIKE %:searchText%")
    List<Product> findAllByAnyColumnContaining(@Param("searchText") String searchText);

}
