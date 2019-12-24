package studentarchive.server;

import studentarchive.SaverLoader;
import studentarchive.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    public static final String REQ_DIVIDER = "---";
    private Socket socket;
    private Server server;

    public ConnectionHandler(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try {

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

            while ((message = (String) ois.readObject()) != null) {

                if ("GET".equals(message.split(REQ_DIVIDER)[0])) {
                    Student student = server.findStudentById(message.split(REQ_DIVIDER)[1]);
                    String sStudent = SaverLoader.getStringFromStudent(student);
                    oos.writeObject(sStudent);

                } else if ("ADD".equals(message.split(REQ_DIVIDER)[0])) {
                    Student student = SaverLoader.getStudentFromString(message.split(REQ_DIVIDER)[1]);
                    server.addStudent(student);
                    oos.writeObject("Added.");

                } else if ("UPDATE".equals(message.split(REQ_DIVIDER)[0])) {
                    Student student = SaverLoader.getStudentFromString(message.split(REQ_DIVIDER)[1]);
                    server.updateStudent(student);
                    oos.writeObject("Updated.");

                } else {
                    oos.writeObject("nothing.");
                }
            }

            ois.close();
            oos.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}