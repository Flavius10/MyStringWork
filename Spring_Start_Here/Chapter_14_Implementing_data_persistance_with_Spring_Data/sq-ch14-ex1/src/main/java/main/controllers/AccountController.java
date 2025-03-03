package main.controllers;

import main.models.Account;
import main.models.TransferRequest;
import main.repo.AccountRepository;
import main.services.TransferService;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.AnnotationValueVisitor;
import javax.security.auth.login.AccountNotFoundException;
import java.util.Iterator;
import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) throws AccountNotFoundException {
        transferService.transferMoney(
                request.getIdSender(),
                request.getIdReceiver(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestHeader(required = false) String name
    ){
        if(name.isEmpty())
            return transferService.getAll();
        else
            return transferService.findAllAccountsByName(name);
    }

}
