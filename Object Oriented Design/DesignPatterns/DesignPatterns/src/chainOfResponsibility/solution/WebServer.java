package chainOfResponsibility.solution;

public class WebServer {
    private Handler handler; // First handler in the chain.

    public WebServer(Handler handler) {
        this.handler = handler;
    }

    public void handle(HttpRequest request) {
        handler.handle(request);
    }
}
