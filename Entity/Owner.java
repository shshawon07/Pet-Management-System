package Entity;

public class Owner {
    private int ownerId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Owner() {}

    public Owner(int ownerId, String name, String phone, String email, String address) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public boolean search(String keyword) {

    keyword = keyword.toLowerCase();

    if (String.valueOf(ownerId).equals(keyword))
        return true;

    if (name.toLowerCase().contains(keyword))
        return true;

    if (phone.toLowerCase().contains(keyword))
        return true;

    if (email.toLowerCase().contains(keyword))
        return true;

    if (address.toLowerCase().contains(keyword))
        return true;

    return false;
}

    public String getOwner() {
        return "Owner ID: " + ownerId + "\n" +
               "Name: " + name + "\n" +
               "Phone: " + phone + "\n" +
               "Email: " + email + "\n" +
               "Address: " + address + "\n";
    }
}
