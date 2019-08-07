package src.main.java;

import src.main.java.model.BookContainer;
import src.main.java.model.PersonContainer;
import src.main.java.view.MainView;

public class Main {

    private static final String ADMIN_CREATION_PASSWORD = "452j9Q";

    public static PersonContainer personContainer = new PersonContainer();
    public static BookContainer bookContainer = new BookContainer();


    public static void main(String[] args) {

        MainView md = new MainView();
        md.startDialog();

    }

    public static String getAdminCreationPassword() {
        return ADMIN_CREATION_PASSWORD;
    }
}
