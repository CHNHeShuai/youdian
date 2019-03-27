package com.youdian.service;

import com.youdian.bean.Category;

import java.util.List;

/**
 * @author hs
 * @date 2019/2/28 - 20:54
 */
public interface CategoryService {

    public List<Category> categoryList();

    public Category getCategoryById(Integer id);

    public void deleteCategory(Integer id);

    public void insertCategory(Category category);

    public void updateCategory(Category category);
}
