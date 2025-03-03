package main.models;

import java.math.BigDecimal;

public class TransferRequest {

    private long idSender;
    private long idReceiver;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public long getIdSender() {
        return idSender;
    }

    public void setIdSender(long idSender) {
        this.idSender = idSender;
    }

    public void setIdReceiver(long idReceiver) {
        this.idReceiver = idReceiver;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
