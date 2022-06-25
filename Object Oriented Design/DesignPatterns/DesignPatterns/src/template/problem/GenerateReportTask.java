package template.problem;

public class GenerateReportTask {
    private AuditTrail auditTrail;

    public GenerateReportTask(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }

    public void execute() {
        auditTrail.record();
        System.out.println("Generate Report");
    }
}

// 1. Code duplication.
// 2. Others not following the structure.
// 1. Polymorphism - Strategy Pattern
// 2. Inheritance

