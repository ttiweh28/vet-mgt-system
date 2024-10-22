package data;

public class User {

    private String firstName;
    private String lastName;
    private int userId;
    private String PhoneNumber;
    private String email;
    private String password;
    private Address address;

    public User() {
    }

    public User(String firstName, String lastName, int userId, String phoneNumber, String email, Address address1) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        PhoneNumber = phoneNumber;
        this.email = email;
        this.address = address1;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
