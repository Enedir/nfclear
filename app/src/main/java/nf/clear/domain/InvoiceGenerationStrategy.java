package nf.clear.domain;

import java.util.List;

public interface InvoiceGenerationStrategy {
    
    List<Invoice> generate(Contract contract, int month, int year);

}
