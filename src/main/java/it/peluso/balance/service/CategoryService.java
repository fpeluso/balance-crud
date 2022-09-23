package it.peluso.balance.service;

import it.peluso.balance.entity.Category;
import it.peluso.balance.model.request.CategoryRequest;
import it.peluso.balance.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//TODO: this is just a draft to allow postman to add new categories
@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAllCategories(){
        return repository.findAll();
    }

    public Category findCategoryByID(long id){
        return repository.findById(id).orElseThrow();
    }

    public Category saveCategory(CategoryRequest request) {
        Category category = new Category();
        category.setCategory(request.getCategory());
        return repository.save(category);
    }
}
