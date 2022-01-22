package ObjectOrientedDesign.Elevator;

public class ElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(5);
        ExternalRequest eRequest1 = new ExternalRequest(3, Direction.DOWN);
        ExternalRequest eRequest2 = new ExternalRequest(2, Direction.UP);
        InternalRequest iRequest1 = new InternalRequest(1);
        InternalRequest iRequest2 = new InternalRequest(5);       

        elevator.handleExternalRequest(eRequest1);
        elevator.handleExternalRequest(eRequest2);

        elevator.run();
        System.out.println(elevator.direction);
        System.out.println(elevator.currentLevel);
        elevator.handleInternalRequest(iRequest1);
        elevator.run();
        System.out.println(elevator.direction);
        System.out.println(elevator.currentLevel);
    }
}
