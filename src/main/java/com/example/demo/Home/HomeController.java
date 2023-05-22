package com.example.demo.Home;

import com.example.demo.Category.CategoryService;
import com.example.demo.Client.ClientService;
import com.example.demo.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final ProductService productService;
    private final ClientService clientService;
    final CategoryService categoryService;

    @Autowired
    public HomeController(ProductService productService, ClientService clientService, CategoryService categoryService) {
        this.productService = productService;
        this.clientService = clientService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("site/index");
        //mv.setViewName("site/main");
        mv.addObject("products", productService.getProducts());
        return mv;
    }

    @GetMapping("/admin")
    public ModelAndView indexAdmin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/index");
        mv.addObject("totalProducts", productService.getProducts().size());
        mv.addObject("totalClients", clientService.getClients().size());
        mv.addObject("totalCategories", categoryService.getCategories().size());
        return mv;
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }
}
