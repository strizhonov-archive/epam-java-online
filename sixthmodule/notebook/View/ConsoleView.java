package notebook.View;

import notebook.Controller.InputChecker;
import notebook.Model.Note;
import notebook.Model.Notebook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleView {

    private Notebook notebook;

    public ConsoleView(Notebook notebook) {
        this.notebook = notebook;
    }

    public void view() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("Choose an action:");
            System.out.println("1. Add new note.");
            System.out.println("2. Find note.");
            System.out.println("3. Print all notes.");
            System.out.println("4. Exit.");

            userInput = sc.nextLine();

            if (InputChecker.checkMainMenuInput(userInput)) {
                mainAction(userInput);
            } else {
                System.out.println("Illegal input.");
            }

        } while (!"4".equals(userInput));

    }

    private void mainAction(String input) {
        switch (input) {
            case "1":
                addNoteDialog();
                break;
            case "2":
                findNotesDialog();
                break;
            case "3":
                if (notebook.getNotes().size() > 0) {
                    System.out.println("Notes:");
                    for (Note note : notebook.getNotes()) {
                        System.out.println(note);
                    }
                } else {
                    System.out.println("No notes found.");
                }
                break;
            default:
                break;
        }
    }

    private void addNoteDialog() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type a topic:");
        String topic = sc.nextLine();

        String date = askDate();

        String[] dates = date.split("-");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(dates[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(dates[1]));
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dates[2]));

        String email = askEmail();

        System.out.println("Type a message:");
        String message = sc.nextLine();

        notebook.addNote(new Note(topic, cal, email, message));
    }

    private void findNotesDialog() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("Find by:");
            System.out.println("1. Topic.");
            System.out.println("2. Date.");
            System.out.println("3. Email.");
            System.out.println("4. Date and email.");
            System.out.println("5. Message or part of message.");
            System.out.println("6. Back.");

            userInput = sc.nextLine();

            if (InputChecker.checkSearchMenuInput(userInput)) {
                findNotesAction(userInput);
            } else {
                System.out.println("Illegal input.");
            }

        } while (!"6".equals(userInput));
    }

    private void findNotesAction(String input) {
        Scanner sc = new Scanner(System.in);
        switch (input) {
            case "1":
                System.out.println("Type a topic:");
                String topic = sc.nextLine();
                printByTopic(topic);
                break;
            case "2":
                String date = askDate();
                printByDate(date);
                break;
            case "3":
                String email = askEmail();
                printByEmail(email);
                break;
            case "4":
                date = askDate();
                email = askEmail();
                printByDateAndEmail(date, email);
                break;
            case "5":
                System.out.println("Type a message or part of message:");
                String message = sc.nextLine();
                printByMessage(message);
                break;
            default:
                break;
        }
    }

    private String askDate() {
        Scanner sc = new Scanner(System.in);
        String date;

        do {
            System.out.println("Type date (in format yyyy-mm-dd):");
            date = sc.nextLine();

            if (!InputChecker.checkDateInput(date)) {
                System.out.println("Illegal input.");
            }

        } while (!InputChecker.checkDateInput(date));

        return date;
    }

    private String askEmail() {
        Scanner sc = new Scanner(System.in);
        String email;

        do {
            System.out.println("Type an email:");
            email = sc.nextLine();

            if (!InputChecker.checkEmailInput(email)) {
                System.out.println("Illegal input.");
            }

        } while (!InputChecker.checkEmailInput(email));

        return email;
    }

    private void printByTopic(String topic) {
        HashMap<Calendar, Note> foundNotes = notebook.getNotesByTopic(topic);

        if (foundNotes.size() > 0) {
            for (Note note : foundNotes.values()) {
                System.out.println(note);
            }
        } else {
            System.out.println("Not found.");
        }

    }

    private void printByEmail(String email) {
        HashMap<Calendar, Note> foundNotes = notebook.getNotesByEmail(email);

        if (foundNotes.size() > 0) {
            for (Note note : foundNotes.values()) {
                System.out.println(note);
            }
        } else {
            System.out.println("Not found.");
        }

    }

    private void printByDate(String date) {
        HashMap<Calendar, Note> foundNotes = notebook.getNotesByDate(date);

        if (foundNotes.size() > 0) {
            for (Note note : foundNotes.values()) {
                System.out.println(note);
            }
        } else {
            System.out.println("Not found.");
        }
    }

    private void printByDateAndEmail(String date, String email) {
        HashMap<Calendar, Note> foundNotes = notebook.getNotesByEmailAndDate(email, date);

        if (foundNotes.size() > 0) {
            for (Note note : foundNotes.values()) {
                System.out.println(note);
            }
        } else {
            System.out.println("Not found.");
        }
    }

    private void printByMessage(String message) {
        HashMap<Calendar, Note> foundNotes = notebook.getNotesByMessage(message);

        if (foundNotes.size() > 0) {
            for (Note note : foundNotes.values()) {
                System.out.println(note);
            }
        } else {
            System.out.println("Not found.");
        }
    }

}
