package tn.enis.bookstrore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enis.bookstrore.dao.CategoryRepository;
import tn.enis.bookstrore.model.Category;
import tn.enis.bookstrore.service.ICategoryService;
import tn.enis.bookstrore.service.impl.CategoryService;

import java.util.List;

@RestController
public class CategoryRestController {

    private ICategoryService categoryService;

    @Autowired
    public CategoryRestController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id).get();
    }

    @GetMapping("/category")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable Long id){
        return categoryService.updateCategory(category,id);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }

}
