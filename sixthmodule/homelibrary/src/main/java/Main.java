package homelibrary.src.main.java;

import homelibrary.src.main.java.model.BookContainer;
import homelibrary.src.main.java.model.PersonContainer;
import homelibrary.src.main.java.view.MainView;

/**
 * Testing class
 */
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
