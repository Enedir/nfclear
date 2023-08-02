package nf.clear;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import nf.clear.domain.Contract;
import nf.clear.domain.Payment;

public class ContractTest {

   
     @Test void shouldCalculateContractBalance() throws ParseException {
        var contract = new Contract("", BigDecimal.valueOf(6000), 12, new Date());
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = (Date) formatter.parse("2022-01-01T10:00:00");   
	    contract.addPayment(new Payment(date, BigDecimal.valueOf(2000)));
        Double balance =  contract.getBalance().doubleValue();
        assertEquals(4000, balance);
    }

     @Disabled ("This test is disabled")
     @Test void shouldGenerateInvoicesFromContract() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = (Date) formatter.parse("2022-01-01T10:00:00");  
        var contract = new Contract("", BigDecimal.valueOf(6000), 12, date);
        var invoices = contract.generateInvoices(1, 2022, "accrual");
        Date expectedDate = (Date) formatter.parse("2022-01-01T13:00:00.000");  
        assertEquals(expectedDate, invoices.get(0).getDate());
        assertEquals(500, invoices.get(0).getAmount().doubleValue());
    };
    
}
