package nf.clear.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {

    private Date date;
    private BigDecimal amount;

    public Invoice(Date date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
