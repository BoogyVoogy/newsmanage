package net.news.service;

import java.util.List;
import net.news.dao.CategoryDAO;
import net.news.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Transactional
    public List<Category> listCategory() {

        return categoryDAO.listCategory();
    }

    @Transactional
    public String getCname(Integer c_id){
        return categoryDAO.getCname(c_id);
    }

    @Transactional
    public void removeCategory(Integer id) {
        categoryDAO.removeCategory(id);
    }
}
