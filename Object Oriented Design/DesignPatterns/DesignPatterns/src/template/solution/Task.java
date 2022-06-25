package template.solution;


public abstract class Task {
    private AuditTrail auditTrail;

/*
    public Task(){
        auditTrail = new AuditTrail();
    }
*/

    //Would be useful if dealing with an interface, decouple from object.
    public Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
    public void execute() {
        auditTrail.record();
        doExecute();
    }

    protected abstract void doExecute();
}
