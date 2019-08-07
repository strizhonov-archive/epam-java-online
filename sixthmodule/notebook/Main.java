package notebook;

import notebook.Controller.WriterReader;
import notebook.Model.Notebook;
import notebook.View.ConsoleView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            Notebook notebook = WriterReader.load();

            ConsoleView cv = new ConsoleView(notebook);
            cv.view();

            WriterReader.flush(notebook);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
