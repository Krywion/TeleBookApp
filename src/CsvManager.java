import com.sun.source.tree.Tree;

import java.io.*;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvManager {

    private static final String FILE_NAME = "telebook.csv";


    public static void save(TeleBook telebook) throws IOException {
        var writer = new BufferedWriter(new FileWriter(FILE_NAME));

        for(Contact contact : telebook.getContacts().values()) {
            writer.write(contact.toCSV());
            writer.newLine();
        }
        writer.close();
    }

    public static TeleBook read(){
        TeleBook teleBook = new TeleBook();
        try {
            var reader = new BufferedReader(new FileReader(FILE_NAME));
            while(true) {
                String line = reader.readLine();
                if(line == null)
                    break;
                String[] separatedLine = line.split(";");
                teleBook.addContact(separatedLine[0], separatedLine[1]);
            }

        } catch (FileNotFoundException e) {
            //ignore just creaty empty TeleBook
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return teleBook;
    }

}
