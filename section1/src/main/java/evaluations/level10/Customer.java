package evaluations.level10;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private boolean preferred;

    public Customer(int customerId, String firstName, String lastName, boolean preferred) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferred = preferred;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }
}
