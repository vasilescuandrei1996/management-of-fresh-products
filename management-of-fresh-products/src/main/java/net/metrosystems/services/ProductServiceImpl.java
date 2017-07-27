package net.metrosystems.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.metrosystems.domain.MarkedProduct;
import net.metrosystems.domain.Product;
import net.metrosystems.domain.User;
import net.metrosystems.repositories.MarkedProductRepository;
import net.metrosystems.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MarkedProductRepository markedProductRepository;

    @Autowired
    private MarkedProductService markedProductService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listProducts() {
        return productRepository.findByIsMarked(false);
    }

    @Override
    public Iterable<MarkedProduct> listProductsMarked() {
        return markedProductRepository.findAll();
    }

    @Override
    public Product getProductByProductId(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> list() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Iterable<Product> listProductsDone() {
        return productRepository.findAll();
    }

    @Override
    public void markProducts(List<Product> markedProducts) {

        User user = userService.getUserByUsername("admin");

        for (Product p : markedProducts) {
            p.setMarked(true);
            productRepository.save(p);
            MarkedProduct markedProduct = new MarkedProduct();
            markedProduct.setProduct(p);
            markedProduct.setUser(user);
            markedProduct.setMarkedDate(new Date());
            markedProductService.saveMarkedProduct(markedProduct);
        }
    }



}
