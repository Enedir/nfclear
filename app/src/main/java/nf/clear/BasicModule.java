package nf.clear;

import com.google.inject.AbstractModule;

import nf.clear.application.repository.ContractRepository;
import nf.clear.application.usecase.GenerateInvoices;
import nf.clear.application.usecase.GenerateInvoicesImpl;
import nf.clear.infra.database.NeonConnection;
import nf.clear.infra.database.NeonContextAdapter;
import nf.clear.infra.http.HttpServer;
import nf.clear.infra.http.JavalinAdapter;
import nf.clear.infra.http.MainController;
import nf.clear.infra.http.Route;
import nf.clear.infra.repository.ContractRepositoryImpl;

public class BasicModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bind(HttpServer.class).to(JavalinAdapter.class);
        bind(Route.class);
        bind(MainController.class);
        bind(NeonConnection.class).to(NeonContextAdapter.class);
        bind(ContractRepository.class).to(ContractRepositoryImpl.class);
        bind(GenerateInvoices.class).to(GenerateInvoicesImpl.class);
    }
}
