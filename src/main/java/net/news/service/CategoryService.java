package net.news.service;

import net.news.domain.Category;

import java.util.List;

/**
 * Created by Bugarchev A.A. on 2016.
 */
public interface CategoryService {
    public void addCategory(Category category);

    public List<Category> listCategory();

    public String getCname(Integer c_id);

    public void removeCategory(Integer id);
}
