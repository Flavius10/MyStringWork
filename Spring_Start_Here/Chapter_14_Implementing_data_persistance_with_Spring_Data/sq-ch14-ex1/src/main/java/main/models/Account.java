package main.models;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id
    private long id;

    private String name;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
