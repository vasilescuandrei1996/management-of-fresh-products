package net.metrosystems.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

  
    private String name;
    private Date expirationDate;
    private String rayon;
    private String lot;
    private String manufacturer;
    private double quantity;
    private boolean isMarked;
    private String imageUrl;
    
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getRayon() {
        return rayon;
    }
    public void setRayon(String rayon) {
        this.rayon = rayon;
    }
    public String getLot() {
        return lot;
    }
    public void setLot(String lot) {
        this.lot = lot;
    }
    public boolean isMarked() {
        return isMarked;
    }
    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

   
    
}
