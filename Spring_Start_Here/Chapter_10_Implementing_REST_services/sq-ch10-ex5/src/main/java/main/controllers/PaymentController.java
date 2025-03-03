package main.controllers;

import main.models.ErrorDetails;
import main.models.NotEnoughMoneyException;
import main.models.PaymentDetails;
import main.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();

            return ResponseEntity.status(HttpStatus.ACCEPTED).
                    body(paymentDetails);
        }catch (NotEnoughMoneyException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(errorDetails);
        }
    }

}
