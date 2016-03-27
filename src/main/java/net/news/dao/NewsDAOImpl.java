package net.news.dao;

import net.news.domain.News;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addNews(News news){
        Date currentDate = new Date();
        news.setDate(currentDate);
        sessionFactory.getCurrentSession().save(news);
    }

    public void changeNews(News news){
        Date currentDate = new Date();
        news.setDate(currentDate);

        Session session = sessionFactory.getCurrentSession();
        News existingNews = (News) session.get(News.class, news.getId());

        existingNews.setDate(currentDate);
        existingNews.setDescr(news.getDescr());
        existingNews.setTitle(news.getTitle());
        existingNews.setC_id(news.getC_id());
        session.save(existingNews);
    }

    public List<News> listNews(){
        return sessionFactory.getCurrentSession().createQuery("from News").list();
    }

    public void removeNews(Integer id){
        News news = (News) sessionFactory.getCurrentSession().load(
                News.class, id);
        if (null != news) {
            sessionFactory.getCurrentSession().delete(news);
        }
    }

    public List<News> listNewsFromCategory(Integer c_id){

        Query query =sessionFactory.getCurrentSession().createQuery("from News where c_id in (:c_id)");
        query.setParameter("c_id",c_id);
        return query.list();

    }

    public News newsArt(Integer id){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(News.class);

        return ((News) criteria.add(Restrictions.eq("id", id)).uniqueResult());
    }

    public List<News> searchArticle(String search){
        Query query =sessionFactory.getCurrentSession().createQuery("from News where title like (:title) or descr like (:title)");
        query.setParameter("title","%"+search+"%");
        return query.list();
    }

    public List<News> newsArticle(Integer id) {
        Query query =sessionFactory.getCurrentSession().createQuery("from News where id in (:id)");
        query.setParameter("id",id);
        return query.list();
    }
}
