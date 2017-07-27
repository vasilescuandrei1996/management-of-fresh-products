package net.metrosystems.services;

import net.metrosystems.domain.MarkedProduct;

public interface MarkedProductService {

    void saveMarkedProduct(MarkedProduct markedProduct);
    
    void markProduct(Integer productId);
    
    MarkedProduct getById(Integer id);
    
    Iterable<MarkedProduct> listMarkedProducts();
}
