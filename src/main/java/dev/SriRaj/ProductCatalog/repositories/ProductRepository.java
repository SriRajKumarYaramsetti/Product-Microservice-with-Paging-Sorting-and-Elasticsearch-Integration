package dev.SriRaj.ProductCatalog.repositories;

import dev.SriRaj.ProductCatalog.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    Optional<Product> findById(Long id);

    @Query("SELECT p FROM Product p")
    List<Product> getAllproducts(Pageable pageable);

    @Query("SELECT p FROM Product p")
    List<Product> findAll();

    void deleteById(Long id);

    List<Product> getProductsByCategory(String category);

    @Query("SELECT DISTINCT p.category FROM Product p")
    List<String> getAllByCategory();

    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
}
