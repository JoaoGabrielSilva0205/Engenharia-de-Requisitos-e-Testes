import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ValidationService {

    private List<ValidationRecord> history = new ArrayList<>();
    private List<LogEntry> logs = new ArrayList<>();

    public boolean validateBeneficiary(String name) {

        Date now = new Date();

        if (name == null || name.trim().isEmpty()) {
            addLog(now, "Validation failed");
            return false;
        }

        history.add(new ValidationRecord(name, "VALID", now));
        addLog(now, "Validation success: " + name);
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

    private void addLog(Date timestamp, String action) {
        logs.add(new LogEntry(timestamp, action));
    }
}
