package nf.clear.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccrualBasisStrategy implements InvoiceGenerationStrategy{

    @Override
    public List<Invoice> generate(Contract contract, int month, int year) {
		var invoices = new ArrayList<Invoice>();
		int period = 0;
		while (period <= contract.getPeriods()) {
            var localDate = LocalDate.ofInstant(contract.getDate().toInstant(), ZoneId.systemDefault());
            var date = localDate.plusMonths(period++);
            var monthValue = date.getMonthValue() + 1;
			if (monthValue != month || date.getYear() != year) continue;
			var amount = contract.getAmount().subtract(new BigDecimal(contract.getPeriods()));
            Date newDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
			invoices.add(new Invoice(newDate, amount));
        }
        return invoices;
    }
    
}
