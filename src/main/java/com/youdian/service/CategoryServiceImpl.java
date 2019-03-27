package com.youdian.service;

import com.youdian.bean.Category;
import com.youdian.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hs
 * @date 2019/2/28 - 20:53
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    @Cacheable(value = "category")
    public List<Category> categoryList() {
        return categoryMapper.categoryList();
    }

    @Override
    @Cacheable(value = "category",key = "#id")
    public Category getCategoryById(Integer id) {
       return categoryMapper.getCategoryById(id);
    }

    @Override
    @CacheEvict(value = "category",allEntries = true)
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
    }

    @Override
    @CacheEvict(value = "category",allEntries = true)
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    @Override
    @CacheEvict(value = "category",allEntries = true)
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
}
