package evaluations.level10;

public class Admin {
    private int adminId;
    private String firstName;
    private String lastName;
    private boolean authorised;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    public Admin(int adminId, String firstName, String lastName, boolean authorised) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorised = authorised;
    }
}
