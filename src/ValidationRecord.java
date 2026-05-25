import java.util.Date;

class ValidationRecord {
    private String name;
    private String status;
    private Date timestamp;

    public ValidationRecord(String name, String status, Date timestamp) {
        this.name = name;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return name + " | " + status + " | " + timestamp;
    }
}
