package tn.enis.bookstrore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enis.bookstrore.dao.CategoryRepository;
import tn.enis.bookstrore.model.Category;
import tn.enis.bookstrore.service.ICategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        category.setId(id);
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
