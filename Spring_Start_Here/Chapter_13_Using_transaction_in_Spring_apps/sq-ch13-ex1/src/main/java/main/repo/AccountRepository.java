package main.repo;

import main.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemp;

    public AccountRepository(JdbcTemplate jdbcTemp){
        this.jdbcTemp = jdbcTemp;
    }

    public Account findAccountById(long id){
        //SELECT BY ID METHOD
        String sql = "SELECT * FROM account WHERE id = ?";
        return jdbcTemp.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAccount(long id, BigDecimal amount){
        // UPDATE METHOD
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbcTemp.update(sql, amount, id);
    }

    public List<Account> getAllAccounts(){
        //SELECT ALL METHOD
        String sql = "SELECT * FROM account";
        return jdbcTemp.query(sql, new AccountRowMapper());
    }

}
