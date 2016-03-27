package net.news.web;

import net.news.domain.Category;
import net.news.domain.News;
import net.news.service.CategoryService;
import net.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Bugarchev A.A. on 2016.
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String redirect(Map<String, Object> map) {

    return "redirect:/news";
    }

    @RequestMapping("/index")
    public String redirectI(Map<String, Object> map) {

        return "redirect:/news";
    }

    @RequestMapping("/news")
    public String listNews(Map<String, Object> map) {

        map.put("news", new News());
        map.put("newsList", newsService.listNews());

        return "news";
    }

    @RequestMapping("/news/{c_id}")
    public String listNewsFromCategory(@PathVariable("c_id") Integer c_id, Map<String, Object> map) {
        map.put("news", new News());
        map.put("newsList", newsService.listNewsFromCategory(c_id));

        return "news";
    }

    @RequestMapping("/news/article/{id}")
    public String listNewsArticle(@PathVariable("id") Integer id, Map<String, Object> map) {
        map.put("news", new News());
        map.put("newsList", newsService.newsArticle(id));
        map.put("category", categoryService.getCname(newsService.newsArticle(id).get(0).getC_id()));

        return "newsArticle";
    }
    @RequestMapping("/createarticle")
    public String newArticle(Map<String, Object> map) {
        map.put("news", new News());
        map.put("category", new Category());
        map.put("categoryList", categoryService.listCategory());

        return "createArticle";
    }

    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute("news") News news,
                             BindingResult result) {

        newsService.addNews(news);

        return "redirect:/index";
    }

    @RequestMapping(value = "/changearticle", method = RequestMethod.POST)
    public String changeArticle(@ModelAttribute("news") News news,

                             BindingResult result) {
    //news.setId(id);
        newsService.changeNews(news);

        return "redirect:/index";
    }

    @RequestMapping("/deletearticle/{aId}")
    public String deleteArticle(@PathVariable("aId") Integer id) {
        newsService.removeNews(id);

        return "redirect:/index";

    }

    @RequestMapping("/changearticle/{aId}")
    public String changeArticle(@PathVariable("aId") Integer id, Map<String, Object> map) {
        //map.put("news", new News());
        map.put("news", newsService.newsArt(id));
        map.put("category", categoryService.getCname(newsService.newsArticle(id).get(0).getC_id()));
        map.put("categoryList", categoryService.listCategory());

        return "changeArticle";

    }

    @RequestMapping("/search")
    public String search(Map<String, Object> map) {
        map.put("news", new News());

        return "search";

    }

    @RequestMapping("/searchresults")
    public String searchResult(@ModelAttribute("news") News news,Map<String, Object> map) {
        map.put("news", new News());
        map.put("newsList", newsService.searchArticle(news.getTitle()));

        return "news";

    }
}