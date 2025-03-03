package repositories;

import models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public PurchaseRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase){

        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

        jdbc.update(sql,
                purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases(){

        String query = "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (r, i) ->{

            Purchase rowDetails = new Purchase();
            rowDetails.setId(r.getInt("id"));
            rowDetails.setProduct(r.getString("product"));
            rowDetails.setPrice(r.getBigDecimal("price"));

            return rowDetails;
        };

        return jdbc.query(query, rowMapper);
    }

}
