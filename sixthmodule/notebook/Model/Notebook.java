package notebook.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notebook {

    private ArrayList<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public HashMap<Calendar, Note> getNotesByTopic(String topic) {
        Pattern pattern = Pattern.compile("(.+)?" + topic + "(.+)?");
        Matcher matcher;

        HashMap<Calendar, Note> foundNotes = new HashMap<>();
        for (Note note : notes) {
            matcher = pattern.matcher(note.getTopic());
            if (matcher.matches()) {
                foundNotes.put(note.getCalendar(), note);
            }
        }

        return foundNotes;
    }

    public HashMap<Calendar, Note> getNotesByEmail(String email) {
        Pattern pattern = Pattern.compile(email);
        Matcher matcher;

        HashMap<Calendar, Note> foundNotes = new HashMap<>();
        for (Note note : notes) {
            matcher = pattern.matcher(note.getEmail());
            if (matcher.matches()) {
                foundNotes.put(note.getCalendar(), note);
            }
        }
        return foundNotes;
    }

    public HashMap<Calendar, Note> getNotesByDate(String date) {
        Pattern pattern = Pattern.compile(date);
        Matcher matcher;

        HashMap<Calendar, Note> foundNotes = new HashMap<>();

        for (Note note : notes) {
            Calendar cal = note.getCalendar();
            matcher = pattern.matcher(cal.get(Calendar.YEAR)
                    + "-"
                    + cal.get(Calendar.MONTH)
                    + "-"
                    + cal.get(Calendar.DAY_OF_MONTH));
            if (matcher.matches()) {
                foundNotes.put(note.getCalendar(), note);
            }
        }
        return foundNotes;
    }

    public HashMap<Calendar, Note> getNotesByEmailAndDate(String email, String date) {
        Pattern datePattern = Pattern.compile(date);
        Pattern emailPattern = Pattern.compile(email);
        Matcher dateMatcher;
        Matcher emailMatcher;

        HashMap<Calendar, Note> foundNotes = new HashMap<>();

        for (Note note : notes) {
            Calendar cal = note.getCalendar();
            dateMatcher = datePattern.matcher(cal.get(Calendar.YEAR)
                    + "-"
                    + cal.get(Calendar.MONTH)
                    + "-"
                    + cal.get(Calendar.DAY_OF_MONTH));
            emailMatcher = emailPattern.matcher(note.getEmail());
            if (dateMatcher.matches() && emailMatcher.matches()) {
                foundNotes.put(note.getCalendar(), note);
            }
        }

        return foundNotes;
    }

    public HashMap<Calendar, Note> getNotesByMessage(String message) {
        Pattern pattern = Pattern.compile("(.+)?" + message + "(.+)?");
        Matcher matcher;

        HashMap<Calendar, Note> foundNotes = new HashMap<>();
        for (Note note : notes) {
            matcher = pattern.matcher(note.getMessage());
            if (matcher.matches()) {
                foundNotes.put(note.getCalendar(), note);
            }
        }

        return foundNotes;

    }
}
