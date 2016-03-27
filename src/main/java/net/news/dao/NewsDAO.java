package net.news.dao;

import net.news.domain.News;

import java.util.List;

/**
 * Created by Bugarchev A.A. on 2016.
 */
public interface NewsDAO {
    public void addNews(News news);

    public void changeNews(News news);

    public List<News> listNews();

    public List<News> listNewsFromCategory(Integer c_id);

    public List<News> newsArticle(Integer id);

    public List<News> searchArticle(String search);

    public News newsArt(Integer id);

    public void removeNews(Integer id);
}
