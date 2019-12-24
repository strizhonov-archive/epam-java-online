package studentarchive.client;

import studentarchive.SaverLoader;
import studentarchive.Student;
import studentarchive.server.ConnectionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(ObjectOutputStream oos, ObjectInputStream ois) {
        this.oos = oos;
        this.ois = ois;
    }

    public Student getStudentById(int id) throws ClassNotFoundException, IOException {
        oos.writeObject("GET" + ConnectionHandler.REQ_DIVIDER + id);
        String sStudent = (String) ois.readObject();
        return SaverLoader.getStudentFromString(sStudent);
    }

    public void addStudent(Student student) throws IOException, ClassNotFoundException {
        oos.writeObject("ADD" + ConnectionHandler.REQ_DIVIDER
                + SaverLoader.getStringFromStudent(student));
        ois.readObject();
    }

    public void updateStudent(Student student) throws IOException, ClassNotFoundException {
        oos.writeObject("UPDATE"
                + ConnectionHandler.REQ_DIVIDER
                + SaverLoader.getStringFromStudent(student));
        ois.readObject();
    }

    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 5556);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Connected...");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ois.readObject();

            Client client = new Client(oos, ois);

            ConsoleView cv = new ConsoleView(client);
            cv.mainMenu();

            ois.close();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}