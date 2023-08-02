package nf.clear.infra.presenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import nf.clear.application.dto.OutputDTO;
import nf.clear.application.presenter.Presenter;

public class CsvPresenter implements Presenter {

    @Override
    public Object present(List<OutputDTO> outputs) {
        var lines = new StringBuilder();
         DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

		for (var data : outputs) {
			var line = new StringBuilder();
			line.append(formatter.format(data.date));
			line.append(data.amount.toString());
			lines.append(line.append(";").toString());
		}
		return lines.append("\n").toString();
    }
    
}
