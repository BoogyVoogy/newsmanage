package net.news.dao;

import java.util.List;
import net.news.domain.Category;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    public List<Category> listCategory() {

        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }
    public String getCname(Integer c_id){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
        return ((Category) criteria.add(Restrictions.eq("id", c_id)).uniqueResult()).getCname();
    }

    public void removeCategory(Integer id) {
        Category category = (Category) sessionFactory.getCurrentSession().load(
                Category.class, id);
        if (null != category) {
            sessionFactory.getCurrentSession().delete(category);
        }

    }
}
