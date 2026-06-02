package ecodoar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationService {

    private List<ValidationRecord> history = new ArrayList<>();
    private List<LogEntry> logs = new ArrayList<>();
    private BeneficiaryRepository repository;

    public ValidationService() {
        this.repository = new BeneficiaryRepository("data/beneficiaries.json");
    }

    public ValidationService(BeneficiaryRepository repository) {
        this.repository = repository;
    }

    public boolean createBeneficiary(Beneficiary beneficiary) {
        return repository.append(beneficiary);
    }

    public boolean validateBeneficiaryById(int id) {

        Date now = new Date();

        Beneficiary beneficiary = repository.findById(id);

        if (beneficiary == null) {
            addLog(now, "Validation failed: beneficiary not found");
            return false;
        }

        if (beneficiary.getName() == null || beneficiary.getName().trim().isEmpty()) {
            addLog(now, "Validation failed: invalid beneficiary name");
            return false;
        }

        history.add(
            new ValidationRecord(
                beneficiary.getId(),
                beneficiary.getName(),
                "VALID",
                now
            )
        );

        addLog(now, "Validation success: " + beneficiary.getName());

        return true;
    }

    public List<ValidationRecord> getHistory() {
        return history;
    }

    public List<LogEntry> getLogs() {
        return logs;
    }

    public void showHistory() {
        System.out.println("\nHistórico:");
        for (ValidationRecord r : history) {
            System.out.println(r);
        }
    }

    public void showLogs() {
        System.out.println("\nLogs:");
        for (LogEntry l : logs) {
            System.out.println(l);
        }
    }

    public void recordAuditLog(String action) {
        addLog(new Date(), action);
    }

    private void addLog(Date timestamp, String action) {
        logs.add(new LogEntry(timestamp, action));
    }

    public BeneficiaryRepository getRepository() {
        return repository;
    }
}