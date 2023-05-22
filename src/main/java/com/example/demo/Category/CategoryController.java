package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categoria/registrar")
    public ModelAndView registar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/Category/create");
        mv.addObject("category", new Category());
        return mv;
    }

    @RequestMapping("/categoria/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/Category/index");
        mv.addObject("categories", categoryService.getCategories());
        return mv;
    }

    @PostMapping("/categoria/criar")
    public String criar(Category category) {
        categoryService.createCategory(category);
        return "admin/Category/create";
    }
}
