package notebook.Controller;

import notebook.Model.Note;
import notebook.Model.Notebook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Calendar;

public class WriterReader {

    private static final String NOTEBOOK_FILE_PATH = "/home/strizhonov/notebook.txt";
    private static final String DIVIDER = "";

    public static Notebook load() throws IOException {

        Notebook notebook = new Notebook();

        new FileOutputStream(NOTEBOOK_FILE_PATH, true).close();

        BufferedReader br = new BufferedReader(new FileReader(NOTEBOOK_FILE_PATH));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }

        String sFile = sb.toString();

        String[] sNotes = sFile.split("\n\n");

        for (String sNote : sNotes) {
            String[] attributes = sNote.split("\n");

            if (attributes.length == 0) {
                break;
            }

            String topic = attributes[0];
            String sDate = attributes[1];
            String[] dateValues = sDate.split("-");

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(dateValues[0]));
            cal.set(Calendar.MONTH, Integer.parseInt(dateValues[1]));
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateValues[2]));

            String email = attributes[2];
            String message = attributes[3];

            Note note = new Note(topic, cal, email, message);
            notebook.addNote(note);
        }

        return notebook;
    }

    public static void flush(Notebook notebook) throws IOException {
        ArrayList<Note> notes = notebook.getNotes();
        ArrayList<String> noteAttributes = new ArrayList<>();

        for (Note note : notes) {
            noteAttributes.add(note.getTopic());

            Calendar cal = note.getCalendar();
            noteAttributes.add(cal.get(Calendar.YEAR)
                    + "-"
                    + cal.get(Calendar.MONTH)
                    + "-"
                    + cal.get(Calendar.DAY_OF_MONTH));

            noteAttributes.add(note.getEmail());
            noteAttributes.add(note.getMessage());
            noteAttributes.add(DIVIDER);
        }

        new FileOutputStream(NOTEBOOK_FILE_PATH, true).close();
        Path file = Paths.get(NOTEBOOK_FILE_PATH);
        Files.write(file, noteAttributes, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
    }

}
