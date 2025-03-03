package main.services;

import main.exceptions.AccountNotFoundException;
import main.models.Account;
import main.repo.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId,
                              long receiverId,
                              BigDecimal amount
    ) throws AccountNotFoundException {

        Account sender =
                accountRepository.findById(senderId)
                        .orElseThrow(() -> new AccountNotFoundException("Contul nu a fost gasit"));
        Account receiver =
                accountRepository.findById(receiverId)
                        .orElseThrow(() ->new AccountNotFoundException("Contul nu a fost gasit"));

        BigDecimal senderAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverAmount = receiver.getAmount().add(amount);

        accountRepository.updateAccountById(senderAmount, senderId);
        accountRepository.updateAccountById(receiverAmount, receiverId);

    }

    public Iterable<Account> getAll(){
        return accountRepository.findAll();
    }

    public List<Account> findAllAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
