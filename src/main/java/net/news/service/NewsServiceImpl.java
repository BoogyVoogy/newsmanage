package net.news.service;

import net.news.dao.NewsDAO;
import net.news.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDAO newsDAO;

    @Transactional
    public void addNews(News news) {
        newsDAO.addNews(news);
    }

    @Transactional
    public void changeNews(News news){
        newsDAO.changeNews(news);
    }

    @Transactional
    public List<News> listNews() {

        return newsDAO.listNews();
    }

    @Transactional
    public List<News> newsArticle(Integer id){

        return newsDAO.newsArticle(id);
    }

    @Transactional
    public List<News> searchArticle(String search){
        return newsDAO.searchArticle(search);
    }

    @Transactional
    public News newsArt(Integer id){
        return newsDAO.newsArt(id);
    }


    @Transactional
    public void removeNews(Integer id) {
        newsDAO.removeNews(id);
    }

    @Transactional
    public List<News> listNewsFromCategory(Integer c_id){
        return newsDAO.listNewsFromCategory(c_id);
    }
}
