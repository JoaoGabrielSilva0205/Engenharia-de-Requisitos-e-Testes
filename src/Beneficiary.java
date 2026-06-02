package ecodoar;

public class Beneficiary {

    private int id;
    private String name;

    public Beneficiary(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}