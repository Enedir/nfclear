package nf.clear.application.dto;

import java.util.Optional;

public class InputDTO {

    public int month, year;
    public String type;
    public Optional<String> format;
    
    public InputDTO() {
    }

    public InputDTO(int month, int year, String type, String format) {
        this.month = month;
        this.year = year;
        this.type = type;
        this.format = Optional.of(format);
    }
 }
