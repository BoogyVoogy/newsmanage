package net.news.web;

/**
 * Created by Bugarchev A.A. on 2016.
 */
import java.util.Map;

import net.news.domain.Category;
import net.news.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("category") Category category,
                             BindingResult result) {

        categoryService.addCategory(category);

        return "redirect:/category";
    }

    @RequestMapping("/category")
    public String listCategory(Map<String, Object> map) {

        map.put("category", new Category());
        map.put("categoryList", categoryService.listCategory());

        return "category";
    }
}
