package chainOfResponsibility.problem;

public class Authenticator {
    public boolean authenticate(HttpRequest request) {
        var isValid = (request.getUsername() == "admin" &&
                request.getPassword() == "1234");
        System.out.println("Authentication");
        return isValid;
    }
}
