package nf.clear.application.presenter;

import java.util.List;

import nf.clear.application.dto.OutputDTO;

public interface Presenter {

    <T> T present (List<OutputDTO> outputs);
    
}
