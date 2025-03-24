package com.thinh.onlinebookstore.mapper;

import com.thinh.onlinebookstore.dto.CategoryDto;
import com.thinh.onlinebookstore.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public CategoryDto toDto( Category category) {
        if (category == null) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }

    public Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public List<CategoryDto> toDtoList(List<Category> categoryList) {
        if (categoryList == null) {
            return null;
        }
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    public List<Category> toEntityList(List<CategoryDto> categoryDtoList) {
        if (categoryDtoList == null) {
            return null;
        }
        List<Category> categoryList = new ArrayList<>();
        for (CategoryDto categoryDto : categoryDtoList) {
            categoryList.add(toEntity(categoryDto));
        }
        return categoryList;
    }
}
