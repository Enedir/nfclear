package nf.clear.infra.http;

import com.google.inject.Inject;

import nf.clear.application.dto.InputDTO;

public class Route {

    @Inject
    private MainController mainController;

    public void create(HttpServer httpServer) {
        httpServer.on("POST", "/generate_invoices", ctx -> {
            var input =  ctx.bodyAsClass(InputDTO.class);
            var output = mainController.post(input);
            ctx.json(output);
        });
    }
    
}
