package net.metrosystems.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MarkedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    
    private Date markedDate;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Date getMarkedDate() {
        return markedDate;
    }
    public void setMarkedDate(Date markedDate) {
        this.markedDate = markedDate;
    }
    
    
    
}
