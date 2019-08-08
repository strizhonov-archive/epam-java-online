package studentarchive.server;

import studentarchive.SaverLoader;
import studentarchive.Student;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static final int PORT = 5556;
    private ServerSocket server;
    private ArrayList<Student> students;

    private Server() throws IOException {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        students = SaverLoader.load();
    }

    private void handleConnection() {
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler(this, socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (id.equals(String.valueOf(student.getId()))) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) throws IOException {
        students.add(student);
        flush();
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.remove(i);
                students.add(student);
                break;
            }
        }
    }

    private void flush() throws IOException {
        SaverLoader.flush(students);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.handleConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
