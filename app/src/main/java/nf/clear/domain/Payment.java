package nf.clear.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="payment")
public class Payment {

    @Id
    private Integer idPayment;

    private Date date;
    
    private BigDecimal amount;

    public Payment() {}

    public Payment(Date date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }

    public Payment(Integer idPayment, Date date, BigDecimal amount) {
        this.idPayment = idPayment;
        this.date = date;
        this.amount = amount;
    }

    @Column(name = "id_payment")
    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
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
