package net.metrosystems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.metrosystems.services.MarkedProductService;
import net.metrosystems.services.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private MarkedProductService markedProductService;

    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("products", productService.listProducts());
        return "products";
    }
    
    @RequestMapping(value = "/products-done", method = RequestMethod.GET)
    public String listProductsDone(Model model){
        model.addAttribute("markedProducts", markedProductService.listMarkedProducts());
        return "products-done";
    }
   

    @RequestMapping("product/{id}")
    public String markProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductByProductId(id));
        markedProductService.markProduct(id);
        return "product-done";
    }

   
}
