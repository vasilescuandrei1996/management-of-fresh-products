package net.metrosystems.bootstrap;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import net.metrosystems.domain.Product;
import net.metrosystems.repositories.ProductRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
       
        Product product1 = new Product();
        product1.setName("Apple");
        product1.setExpirationDate(new Date());
        product1.setManufacturer("anca");
        product1.setQuantity(100);
        product1.setImageUrl(" http://dreamicus.com/data/apple/apple-03.jpg");
       
        product1.setMarked(false);
        product1.setRayon("rayon 1");
        product1.setLot("2");
        productRepository.save(product1);

        log.info("Saved product1 - id: " + product1.getProductId());

        
        Product product2 = new Product();
        product2.setName("Beer");
        product2.setManufacturer("anca");
        product2.setImageUrl("https://www.bauturaonline.ro/49-tm_thickbox_default/bere-heineken-033-5.jpg");
        product2.setQuantity(100);
        product2.setExpirationDate(new Date());
        product2.setMarked(false);
        product2.setRayon("rayon 1");
        product2.setLot("4");
        productRepository.save(product2);

        log.info("Saved product2 - id:" + product2.getProductId());
        
       
        Product product3 = new Product();
        product3.setName("Orange");
        product3.setExpirationDate(new Date());
        product3.setManufacturer("anca");
        product3.setImageUrl("http://upoharobazarbd.com/wp-content/uploads/2016/02/orange.jpg");
        product3.setQuantity(100);
        product3.setMarked(false);
        product3.setRayon("rayon 2");
        product3.setLot("4");
        productRepository.save(product3);

        log.info("Saved product3 - id: " + product3.getProductId());
        
        
        Product product4 = new Product();
        product4.setName("Lemon");
        product4.setExpirationDate(new Date());
        product4.setManufacturer("anca");
        product4.setImageUrl("http://www.proto.gr/sites/www.proto.gr/files/styles/large_retina/public/images/fruits/lemon.png?itok=RL421AW4");
        product4.setQuantity(100);
        product4.setMarked(false);
        product4.setRayon("rayon 2");
        product4.setLot("4");
        productRepository.save(product4);

        log.info("Saved product4 - id: " + product4.getProductId());
        
     
        
    }
}
