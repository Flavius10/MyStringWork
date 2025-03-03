package models;

import java.math.BigDecimal;

public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
