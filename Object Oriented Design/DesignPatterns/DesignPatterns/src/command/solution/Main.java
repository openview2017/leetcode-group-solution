package command.solution;

import command.solution.framework.AddCustomerCommand;
import command.solution.framework.Button;

public class Main {
    public static void main(String[] args) {
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
