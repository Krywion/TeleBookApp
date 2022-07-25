public class Contact implements Comparable<Contact>{
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Contact c) {
        return this.name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }

    public String toCSV() {
        return name + ";" + phoneNumber;
    }
}
