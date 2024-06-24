package section2.level3;

public class User {
    public int id;
    public String firstName;
    public String lastName;
    public UserAddress userAddress;

    public User(int id, String firstName, String lastName,
                UserAddress userAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAddress = userAddress;
    }

    public static class UserAddress {
        public String street;
        public String city;
        public String pinCode;

        public UserAddress(String street, String city, String pinCode) {
            this.street = street;
            this.city = city;
            this.pinCode = pinCode;
        }

        public void displayAddress() {
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
            System.out.println("ZIP: " + pinCode);
        }
    }

}
