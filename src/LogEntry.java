import java.util.Date;

class LogEntry {
    private Date timestamp;
    private String action;

    public LogEntry(Date timestamp, String action) {
        this.timestamp = timestamp;
        this.action = action;
    }

    public String toString() {
        return timestamp + " | " + action;
    }
}
