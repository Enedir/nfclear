package nf.clear.domain;

public class InvoiceGenerationFactory {

    public static InvoiceGenerationStrategy create(String type) {
        if("cash".equals(type)) {
            return new CashBasisStrategy();
        }

        if("accrual".equals(type)) {
            return new AccrualBasisStrategy();
        }

        throw new RuntimeException("Type not exist");

    }
    
}
