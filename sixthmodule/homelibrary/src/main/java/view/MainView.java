package homelibrary.src.main.java.view;

import homelibrary.src.main.java.model.person.Admin;
import homelibrary.src.main.java.model.person.Person;
import homelibrary.src.main.java.model.person.User;

public class MainView {

    public void startDialog() {
        while (true) {
            LoginView lv = new LoginView();
            lv.showLogInMenu();

            Person currentPerson = lv.getCurrentPerson();

            if (currentPerson instanceof User) {
                UserView mv = new UserView((User) currentPerson);
                mv.showMainDialog();
            } else {
                AdminView av = new AdminView((Admin) currentPerson);
                av.showMainDialog();
            }
        }
    }

}
