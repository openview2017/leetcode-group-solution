package chainOfResponsibility.problem;

public class WebServer {
    public void handle(HttpRequest request) {
        // Authentication
        var authenticator = new Authenticator();
        authenticator.authenticate(request);
        // Logging
        // Compression

        // Problem:
        // 1. Webserver coupled with authenticator, logger and compressor.
        // We can use Interface to decouple.
        // 2. Order of the actions are hard coded. If we want to add/disable one of them, we need to change the code.

        // Solution:
        // Build a pipeline with a chain of objects that processes requests(Not only HttpRequests)
    }
}
