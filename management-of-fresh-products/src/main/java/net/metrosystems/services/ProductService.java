package net.metrosystems.services;


import java.util.List;

import net.metrosystems.domain.MarkedProduct;
import net.metrosystems.domain.Product;

public interface ProductService {
      
    Iterable<Product> listProducts();
    
    List<Product> list();
    
    Iterable<Product> listProductsDone();

    Product getProductByProductId(Integer id);
    
    Product saveProduct(Product product);

    Iterable<MarkedProduct> listProductsMarked();

    void markProducts(List<Product> markedProducts);
}
