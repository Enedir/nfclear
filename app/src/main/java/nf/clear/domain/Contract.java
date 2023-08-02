package nf.clear.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="contract")
public class Contract {

    @Id
    private Integer idContract;

    private String description;
    
    private BigDecimal amount;
    
    private Integer periods;
    
    private Date date;

    private List<Payment> payments;

    public Contract() {
        this.payments = new ArrayList<>();
    }

    public Contract(String description, BigDecimal amount, Integer periods, Date date) {
        this.description = description;
        this.amount = amount;
        this.periods = periods;
        this.date = date;
        this.payments = new ArrayList<>();
    }

    public Contract(Integer idContract, String description, BigDecimal amount, Integer periods, Date date) {
        this.idContract = idContract;
        this.description = description;
        this.amount = amount;
        this.periods = periods;
        this.date = date;
        this.payments = new ArrayList<>();
    }


    @Column(name = "id_contract")
    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(Payment payment) {
		this.payments.add(payment);
	}

    public BigDecimal getBalance () {
		var balance = this.amount;
		for (var payment : this.payments) {
			balance = balance.subtract(payment.getAmount());
		}
		return balance;
	}

    public List<Invoice> generateInvoices(int month, int year, String type) {
		var invoiceGenerationStrategy = InvoiceGenerationFactory.create(type);
		return invoiceGenerationStrategy.generate(this, month, year);
	}
}
