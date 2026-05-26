import java.util.Date;

class ValidationRecord {

    private int beneficiaryId;
    private String beneficiaryName;
    private String status;
    private Date timestamp;

    public ValidationRecord(int beneficiaryId, String beneficiaryName, String status, Date timestamp) {

        this.beneficiaryId = beneficiaryId;
        this.beneficiaryName = beneficiaryName;
        this.status = status;
        this.timestamp = timestamp;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public String getStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String toString() {
        return beneficiaryId + " | " + beneficiaryName + " | " + status + " | " + timestamp;
    }
}