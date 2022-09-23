package it.peluso.balance.controller;

import it.peluso.balance.entity.Category;
import it.peluso.balance.model.request.CategoryRequest;
import it.peluso.balance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: this is just a draft to allow postman to add new categories
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        return new ResponseEntity<>(
                service.findAllCategories(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(
            @PathVariable long id
    ){
        return new ResponseEntity<>(
                service.findCategoryByID(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(
            @RequestBody CategoryRequest request
    ) {
        try{
            return new ResponseEntity<>(
                    service.saveCategory(request),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return null;
        }
    }
}
