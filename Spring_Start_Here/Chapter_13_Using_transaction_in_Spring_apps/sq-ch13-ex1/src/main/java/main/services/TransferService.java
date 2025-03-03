package main.services;

import main.models.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.repo.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender,
                              long idReceiver,
                              BigDecimal amount){

        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = sender.getAmount().add(amount);

        accountRepository.changeAccount(idSender, senderNewAmount);
        accountRepository.changeAccount(idReceiver, receiverNewAmount);

    }

    public List<Account> getAllAccounts(){
        return accountRepository.getAllAccounts();
    }

}
