import java.util.NoSuchElementException;

public enum OPTIONS {
    ADD_CONTACT(0, "Dodaj Kontakt"),
    SEARCH_BY_NAME(1, "Szukaj po nazwie"),
    SEARCH_BY_TEL(2, "Szukaj po telefonie"),
    DELETE(3, "Usuń"),
    CLOSE(4, "Koniec");

    private final int shortcut;
    private final String description;

    OPTIONS(int shortcut, String descriptions) {
        this.shortcut = shortcut;
        this.description = descriptions;
    }

    public int getShortcut() {
        return shortcut;
    }

    static OPTIONS convertToOption(int option) {
        if(option >= values().length || option < 0) {
            throw new NoSuchElementException();
        }
        return values()[option];
    }

    @Override
    public String toString() {
        return shortcut + "-" + description;
    }
}
