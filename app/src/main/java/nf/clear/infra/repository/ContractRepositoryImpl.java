package nf.clear.infra.repository;

import java.util.List;

import com.dieselpoint.norm.Database;
import com.google.inject.Inject;

import nf.clear.application.repository.ContractRepository;
import nf.clear.domain.Contract;
import nf.clear.infra.database.NeonConnection;

public class ContractRepositoryImpl implements ContractRepository {

    private Database context;

    @Inject
    public ContractRepositoryImpl(NeonConnection connection) throws Exception {
        this.context = connection.createContext();
    }

    @Override
    public List<Contract> list() {
        return this.context.sql("select * from contract").results(Contract.class);
    }
    
}
