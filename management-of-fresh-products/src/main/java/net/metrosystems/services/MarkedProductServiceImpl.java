package net.metrosystems.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.metrosystems.domain.MarkedProduct;
import net.metrosystems.domain.Product;
import net.metrosystems.domain.User;
import net.metrosystems.repositories.MarkedProductRepository;

@Service
public class MarkedProductServiceImpl implements MarkedProductService {

    @Autowired
    private MarkedProductRepository markedProductRepository;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;

    @Override
    public void saveMarkedProduct(MarkedProduct markedProduct) {
        markedProductRepository.save(markedProduct);
    }

    @Override
    public MarkedProduct getById(Integer id) {
       return markedProductRepository.findOne(id);
    }

    @Override
    public Iterable<MarkedProduct> listMarkedProducts() {
        return markedProductRepository.findAll();
    }

    @Override
    public void markProduct(Integer productId) {
        Product product = productService.getProductByProductId(productId);
        product.setMarked(true);
        User user = userService.getUserByUsername("admin");
        MarkedProduct markedProduct = new MarkedProduct();
        markedProduct.setProduct(product);
        markedProduct.setUser(user);
        markedProduct.setMarkedDate(new Date());
        productService.saveProduct(product);
        saveMarkedProduct(markedProduct);
    }
    
    
}
