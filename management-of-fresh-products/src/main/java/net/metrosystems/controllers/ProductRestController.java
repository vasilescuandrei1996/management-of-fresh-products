package net.metrosystems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.metrosystems.domain.MarkedProduct;
import net.metrosystems.domain.Product;
import net.metrosystems.repositories.MarkedProductRepository;
import net.metrosystems.services.ProductService;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MarkedProductRepository markedProductRepository;


    @RequestMapping(value = "/products-to-do", method = RequestMethod.GET)
    public List<Product> listAllProducts() {
        return (List<Product>) productService.listProducts();
    }

    @RequestMapping(value = "/products-marked", method = RequestMethod.GET)
    public List<MarkedProduct> listAllMarkedProducts() {
        return (List<MarkedProduct>) markedProductRepository.findAll();
    }

    @RequestMapping(value = "/mark-products", method = RequestMethod.POST)
    public String markProducts(@RequestBody List<Product> markedProducts) {
        productService.markProducts(markedProducts);
        return "200 Succes";
    }


}
