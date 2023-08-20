package nf.clear.application.usecase;

import java.util.ArrayList;

import com.google.inject.Inject;

import nf.clear.application.dto.InputDTO;
import nf.clear.application.dto.OutputDTO;
import nf.clear.application.presenter.Presenter;
import nf.clear.application.repository.ContractRepository;

public class GenerateInvoicesImpl implements GenerateInvoices{

    private ContractRepository contractRepository;

    @Inject
    public GenerateInvoicesImpl(ContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }


    @Override
    public <T> T execute(InputDTO input, Presenter present) {
        var output = new ArrayList<OutputDTO>();
        var contracts  = this.contractRepository.list();

        for(var contract : contracts) {
            var invoices = contract.generateInvoices(input.month, input.year, input.type);
            for (var invoice : invoices) {
				output.add(new OutputDTO(invoice.getDate(), invoice.getAmount()));
			}
        }

        return present.present(output);
    }
}
