import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class TeleBook implements Iterable<Contact>{
    private TreeMap<String, Contact> contacts = new TreeMap<>();

    public TeleBook() {}

    public TeleBook(TreeMap<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public boolean addContact(String name, String phoneNumber) {
        if(name == null || phoneNumber == null)
            throw new NullPointerException("name and phoneNumber cannot be null");
        if(name.isEmpty() || phoneNumber.isEmpty())
            throw new IllegalArgumentException("name and phoneNumber cannot be empty");
        if(!contacts.containsKey(name)) {
            contacts.put(name, new Contact(name, phoneNumber));
            return true;
        } else
            return false;

    }

    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

    public ArrayList<Contact> findByName(String name) {
        ArrayList<Contact> result = new ArrayList<>();
        for(var entry : contacts.entrySet()) {
            if(entry.getKey().contains(name)) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public ArrayList<Contact> findByPhone(String phoneNumber) {
        ArrayList<Contact> result = new ArrayList<>();
        for(Contact contact : contacts.values()) {
            if(contact.getPhoneNumber().contains(phoneNumber))
                result.add(contact);
        }
        return result;
    }

    public TreeMap<String, Contact> getContacts() {
        return contacts;
    }

    public void setContacts(TreeMap<String, Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Iterator<Contact> iterator() {
        return contacts.values().iterator();
    }
}
