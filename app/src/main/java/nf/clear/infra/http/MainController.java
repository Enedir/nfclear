package nf.clear.infra.http;

import com.google.inject.Inject;

import nf.clear.application.dto.InputDTO;
import nf.clear.application.usecase.GenerateInvoices;
import nf.clear.infra.presenter.JsonPresenter;

public class MainController {
  
  private GenerateInvoices generateInvoices;

  @Inject
  public MainController(GenerateInvoices generateInvoices) {
    this.generateInvoices = generateInvoices;

  }

  public <T> T post(InputDTO input){
    return this.generateInvoices.execute(input, new JsonPresenter());
  }
    
}
