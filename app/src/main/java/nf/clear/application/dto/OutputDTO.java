package nf.clear.application.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OutputDTO {
    
    public Date date;
    public BigDecimal amount;

    public OutputDTO() {
    }

    public OutputDTO(Date date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }
 }
