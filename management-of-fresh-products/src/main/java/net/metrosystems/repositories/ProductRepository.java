package net.metrosystems.repositories;

import org.springframework.data.repository.CrudRepository;

import net.metrosystems.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    Iterable<Product> findByIsMarked(boolean isMarkAsDone);
}
