package com.example.demo.Product;

import com.example.demo.Category.CategoryService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
public class ProductController {
    private final ProductService productService;
    private final CategoryService cateroryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService cateroryService) {
        this.productService = productService;
        this.cateroryService = cateroryService;
    }

    @GetMapping("/produto_criar")
    public ModelAndView registar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/Product/create");
        mv.addObject("product", new Product());
        mv.addObject("categories", cateroryService.getCategories());
        return mv;
    }

    @PostMapping("/registrar_produto")
    public ResponseEntity<String> registar_client(@RequestParam("img") @NotNull MultipartFile file,
                                  @RequestParam("name") String name,
                                  @RequestParam("price") double price)

            throws IOException {
                Product product = new Product();
                //productService.createClient(client);
                if (!file.isEmpty()) {
                    Path path = Paths.get("src/main/resources/static/images");
                    String filename = file.getOriginalFilename();
                    Files.createDirectories(path);
                    Path filePath = path.resolve(filename);
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                    product.setImg(filename);
                    product.setName(name);
                    product.setPrice(price);

                    productService.createProduct(product);
                    return new ResponseEntity<>("Produto cadastrado com sucesso.", HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("Não foi possível cadastrar o produto.", HttpStatus.NOT_FOUND);
                }

        //return "admin/Product/create";
    }

    @RequestMapping("/products/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/Product/index");
        mv.addObject("products", productService.getProducts());
        return mv;
    }

    @GetMapping("/products/alterar/{id}")
    public ModelAndView update(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        Product product = new Product();
        product = productService.getProduct(id);
        mv.addObject("product", product);
        mv.setViewName("admin/Product/update");
        return mv;
    }

    @PostMapping("/products/alterar")
    public ModelAndView store(@RequestParam("img") @NotNull MultipartFile file,
                              @RequestParam("name") String name,
                              @RequestParam("id") Integer id,
                              @RequestParam("price") double price)

            throws IOException {
        ModelAndView mv = new ModelAndView();
        Product product = new Product();
        //productService.createClient(client);
        if (!file.isEmpty()) {
            Path path = Paths.get("src/main/resources/static/images");
            String filename = file.getOriginalFilename();
            Files.createDirectories(path);
            Path filePath = path.resolve(filename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            product.setImg(filename);
            product.setId(id);
            product.setName(name);
            product.setPrice(price);

            productService.updateProduct(product);
            mv.setViewName("admin/Product/index");
            mv.addObject("products", productService.getProducts());
        }else{
            mv.setViewName("admin/Product/update");
        }

        return mv;
    }

    @GetMapping("/products/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        if (productService.existsById(id)){
            productService.deleteById(id);
        }

        mv.setViewName("admin/Product/index");
        mv.addObject("products", productService.getProducts());

        return mv;
    }
}
