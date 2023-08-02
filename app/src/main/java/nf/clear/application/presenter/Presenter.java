package nf.clear.application.presenter;

import java.util.List;

import nf.clear.application.dto.OutputDTO;

public interface Presenter {

    Object present (List<OutputDTO> outputs);
    
}
