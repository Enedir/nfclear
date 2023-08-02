package nf.clear.infra.http;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class JavalinAdapter implements HttpServer
 {
    private  Javalin app;

    public JavalinAdapter(){
        app =  Javalin.create();
    }

    @Override
    public void on(String method, String url, Handler callback) {
     switch(method) {
        case "POST":
         this.app.post(url, callback);
        break;
        case "GET":
         this.app.get(url, callback);
        break;
        case "PUT": 
         this.app.put(url, callback);
        break;
        case "PATCH":
         this.app.patch(url, callback); 
        break;
        case "DELETE": 
         this.app.delete(url, callback);
        break;
        default: 
            throw new UnsupportedOperationException();

     }
    }

    @Override
    public void listen(Integer port) {
        this.app.start(port);
    }
    
}
