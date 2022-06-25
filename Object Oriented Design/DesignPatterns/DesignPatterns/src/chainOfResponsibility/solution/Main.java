package chainOfResponsibility.solution;

public class Main {
    public static void main(String[] args){
        // authenticator -> logger -> compressor
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);
        //server.handle(new HttpRequest("admin", "1234"));
        server.handle(new HttpRequest("-", "1234"));

        /* authenticator -> compressor
        var compressor = new Compressor(null);
        //var logger = new Logger(compressor);
        var authenticator = new Authenticator(compressor);
        var server = new WebServer(authenticator);
        //server.handle(new HttpRequest("admin", "1234"));
        server.handle(new HttpRequest("-", "1234"));*/
    }
}
