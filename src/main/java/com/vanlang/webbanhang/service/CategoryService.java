package com.vanlang.webbanhang.service;

import com.vanlang.webbanhang.model.Category;
import com.vanlang.webbanhang.repository.CategoryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    /**
     * trả về tất cả categories trong db.
     * @return a list of categories
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }

    /**
     * tìm kiếm theo id
     */
    public Optional<Category> getCategoryById (long id) {
        return categoryRepository.findById(id);

    }

    /**
     * them du lieu moi vao category
     * @param category
     */
    public void addCategory (Category category) {
        categoryRepository.save(category);

    }

    /**
     * Update
     * @param category
     */
    public void updateCategory(@NonNull Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElseThrow(() ->
                new IllegalStateException("Category with ID " + category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
    }

    /**
     * Xóa
     * @param id
     */
    public void deleteCategory (Long id) {
        if(!categoryRepository.existsById(id)) {
            throw  new IllegalStateException("Category with ID:" + id + "does not exist");
        }
        categoryRepository.deleteById(id);
    }





}