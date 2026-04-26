import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ValidationService {

    private List<ValidationRecord> history = new ArrayList<>();
    private List<LogEntry> logs = new ArrayList<>();

    public void validateBeneficiary(String name) {

        Date now = new Date();

        // Validação de input
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erro: nome inválido.");
            addLog(now, "Validation failed");
            return;
        }

        // Registar validação
        history.add(new ValidationRecord(name, "VALID", now));

        System.out.println("Beneficiário validado.");

        // Log obrigatório
        addLog(now, "Validation success: " + name);
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
