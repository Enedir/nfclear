package nf.clear.infra.presenter;

import java.util.List;

import nf.clear.application.dto.OutputDTO;
import nf.clear.application.presenter.Presenter;

public class JsonPresenter implements Presenter{

    @Override
    public <T> T present(List<OutputDTO> outputs) {

        return (T) outputs;
    }
    
}
