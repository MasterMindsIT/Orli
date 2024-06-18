package com.invoice.categories;



import java.util.List;

public interface CategoryExternalAPI {
    CategoryDTO getCategoryyId(Long id);
    List<CategoryDTO> getAllCategory();
    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long id);
}
