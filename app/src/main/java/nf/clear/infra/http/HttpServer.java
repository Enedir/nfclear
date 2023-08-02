package nf.clear.infra.http;

import io.javalin.http.Handler;

public interface HttpServer {
    void on (String method, String url, Handler callback);
	void listen (Integer port);
}
