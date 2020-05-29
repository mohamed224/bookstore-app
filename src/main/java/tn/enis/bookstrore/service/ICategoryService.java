package tn.enis.bookstrore.service;

import tn.enis.bookstrore.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category saveCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Category category,Long id);
    void deleteCategoryById(Long id);
}
