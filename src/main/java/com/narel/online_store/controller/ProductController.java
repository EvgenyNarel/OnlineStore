package com.narel.online_store.controller;

import com.narel.online_store.model.Product;
import com.narel.online_store.service.ProductServiceImpl;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String findAll(Model model) {
        List<Product> product = productService.findAll();
        model.addAttribute("product", product);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product) {
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model) {
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product";
    }
}


