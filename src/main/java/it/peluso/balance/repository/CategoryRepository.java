package it.peluso.balance.repository;

import it.peluso.balance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//TODO: this is just a draft to allow postman to add new categories
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
