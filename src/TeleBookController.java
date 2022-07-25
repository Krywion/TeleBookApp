import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeleBookController {
    private TeleBook teleBook;

    public TeleBookController() {
        teleBook = CsvManager.read();
    }
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void loop() {
        while(true) {
            showOptions();
            Integer choice = null;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            executeOption((OPTIONS.convertToOption(choice)));
        }

    }

    private void showOptions() {
        for (OPTIONS option : OPTIONS.values()) {
            System.out.println(option.toString());
        }
    }

    private void executeOption(OPTIONS options) {
        switch(options.getShortcut()) {
            case 0: {
                addContact();
                break;
            }
            case 1: {
                searchByName();
                break;
            }
            case 2: {
                searchByPhoneNumber();
                break;
            }
            case 3: {
                delete();
                break;
            }
            case 4: {
                close();
                break;
            }
        }
    }

    private void delete() {
        try {
            System.out.print("Usuń: ");
            String name = reader.readLine();
            System.out.println();
            if(teleBook.removeContact(name)) {
                System.out.println("Pomyślnie usunięto kontakt: " + name);
            }
            else {
                System.out.println("Nie znaleziono kontaktu:" + name);
                System.out.println("Podobne rekordy: ");
                searchByName(name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void searchByName() {
        try {
            System.out.print("Szukaj: ");
            String argue = reader.readLine();
            for(Contact contact : teleBook.findByName(argue)) {
                System.out.println(contact.toString());
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private void searchByName(String name) {
        String argue = name;
        for(Contact contact : teleBook.findByName(argue)) {
            System.out.println(contact.toString());
        }
        System.out.println();
    }

    private void searchByPhoneNumber() {
        try {
            System.out.print("Numer: ");
            String phoneNumber = reader.readLine();
            for(Contact contact : teleBook.findByPhone(phoneNumber)) {
                System.out.println(contact.toString());
            }
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException();
        }


    }

    private void addContact() {
        try {
            System.out.print("Wprowadź imię: ");
            String name = reader.readLine();
            System.out.println();
            System.out.print("Wprowadź numer telefonu: ");
            String phoneNumber = reader.readLine();
            System.out.println();

            teleBook.addContact(name, phoneNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void close() {
        try {
            CsvManager.save(teleBook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

}
