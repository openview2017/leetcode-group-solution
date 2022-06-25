package template.problem;

public class Main {
    public static void main(String[] args){
        var task = new TransferMoneyTask(new AuditTrail());
        task.execute();
    }
}
