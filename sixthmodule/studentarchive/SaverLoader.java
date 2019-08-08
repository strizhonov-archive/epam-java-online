package studentarchive;

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

public class SaverLoader {

    private static final String DIVIDER = "";
    private static final String ARCHIVE_FILE_PATH = "/home/strizhonov/archive.txt";

    public static ArrayList<Student> load() throws IOException {
        new FileOutputStream(ARCHIVE_FILE_PATH, true).close();

        BufferedReader br = new BufferedReader(new FileReader(ARCHIVE_FILE_PATH));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }

        String sFile = sb.toString();

        ArrayList<Student> students = new ArrayList<>();
        String[] sStudents = sFile.split("\n\n");

        for (String sStudent : sStudents) {
            String[] attributes = sStudent.split("\n");

            if (attributes.length == 0) {
                break;
            }

            if (attributes.length == 1 && "".equals(attributes[0])) {
                break;
            }

            String sId = attributes[0];
            int id = Integer.parseInt(sId);
            String name = attributes[1];
            String lastName = attributes[2];
            String sGroup = attributes[3];
            int group = Integer.parseInt(sGroup);

            students.add(new Student(id, name, lastName, group));
        }
        return students;
    }

    public static Student getStudentFromString(String sStudent) {
        if (sStudent == null) {
            return null;
        }
        String[] attributes = sStudent.split("\n");

        if (attributes.length == 0) {
            return null;
        }

        String sId = attributes[0];
        int id = Integer.parseInt(sId);
        String name = attributes[1];
        String lastName = attributes[2];
        String sGroup = attributes[3];
        int group = Integer.parseInt(sGroup);

        return new Student(id, name, lastName, group);
    }

    public static String getStringFromStudent(Student student) {
        if (student == null) {
            return null;
        } else {
            return student.getId() + "\n"
                    + student.getFirstName() + "\n"
                    + student.getLastName() + "\n"
                    + student.getGroup();
        }
    }

    public static void flush(ArrayList<Student> students) throws IOException {
        new FileOutputStream(ARCHIVE_FILE_PATH, false).close();

        for (Student student : students) {
            writeStudent(student);
        }
    }

    private static void writeStudent(Student student) throws IOException {
        ArrayList<String> studentAttributes = new ArrayList<>();
        studentAttributes.add(String.valueOf(student.getId()));
        studentAttributes.add(student.getFirstName());
        studentAttributes.add(student.getLastName());
        studentAttributes.add(String.valueOf(student.getGroup()));
        studentAttributes.add(DIVIDER);

        new FileOutputStream(ARCHIVE_FILE_PATH, true).close();
        Path file = Paths.get(ARCHIVE_FILE_PATH);
        Files.write(file, studentAttributes, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

}
