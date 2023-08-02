package nf.clear.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CashBasisStrategy implements InvoiceGenerationStrategy{

    @Override
    public List<Invoice> generate(Contract contract, int month, int year) {
        var invoices = new ArrayList<Invoice>();
        for (var payment : contract.getPayments()) {
            var date = LocalDate.ofInstant(payment.getDate().toInstant(), ZoneId.systemDefault());
			if (date.getMonthValue() + 1 != month || date.getYear() != year) continue;
			invoices.add(new Invoice(payment.getDate(), payment.getAmount()));
		}
		return invoices;
    }
    
}
