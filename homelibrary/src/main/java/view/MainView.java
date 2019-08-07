package view;

import model.person.Admin;
import model.person.Person;
import model.person.User;


public class MainView {

    public void startDialog() {
        while (true) {
            LoginView lv = new LoginView();
            lv.showLogInMenu();

            Person currentPerson = lv.getCurrentPerson();

            if (currentPerson instanceof User) {
                UserView mv = new UserView((User)currentPerson);
                mv.showMainDialog();
            } else {
                AdminView av = new AdminView((Admin)currentPerson);
                av.showMainDialog();
            }
        }
    }

}
