package studentarchive.client;

import studentarchive.InputChecker;
import studentarchive.Student;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleView {

    private Client client;

    public ConsoleView(Client client) {
        this.client = client;
    }

    public void mainMenu(){

        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("Choose an action:");
            System.out.println("1. Find student info.");
            System.out.println("2. Change student info.");
            System.out.println("3. Create student profile.");
            System.out.println("4. Exit.");

            userInput = sc.nextLine();

            boolean isInputCorrect = InputChecker.checkMainMenuInput(userInput);

            if (isInputCorrect) {
                mainAction(userInput);
            } else {
                System.out.println("Illegal input.");
            }

        } while (!"4".equals(userInput));
    }

    private void mainAction(String input) {
        switch (input) {
            case "1":
                findStudentDialog();
                break;
            case "2":
                changeStudentDialog();
                break;
            case "3":
                studentCreationDialog();
                break;
            default:
                break;

        }
    }

    private void findStudentDialog() {
        Scanner sc = new Scanner(System.in);
        boolean isInputCorrect;
        int id = -1;
        do {
            System.out.println("Type student id:");
            String sId = sc.nextLine();

            isInputCorrect = InputChecker.checkNumInput(sId);
            if (isInputCorrect) {
                id = Integer.parseInt(sId);;
            } else {
                System.out.println("Illegal input.");
            }

        } while (!isInputCorrect);

        try {
            Student student = client.getStudentById(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    private void changeStudentDialog() {
        Scanner sc = new Scanner(System.in);

        boolean isInputCorrect;
        int id = -1;
        do {
            System.out.println("Type student id:");
            String sId = sc.nextLine();

            isInputCorrect = InputChecker.checkNumInput(sId);
            if (isInputCorrect) {
                id = Integer.parseInt(sId);;
            } else {
                System.out.println("Illegal input.");
            }

        } while (!isInputCorrect);

        try {
            Student student = null;
            try {
                student = client.getStudentById(id);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (student != null) {
                System.out.println("Enter new first name:");
                student.setFirstName(sc.nextLine());

                System.out.println("Enter new last name:");
                student.setLastName(sc.nextLine());

                do {
                    System.out.println("Enter new group No:");
                    String userInput = sc.nextLine();

                    isInputCorrect = InputChecker.checkNumInput(userInput);
                    if (isInputCorrect) {
                        int intInput = Integer.parseInt(userInput);
                        student.setGroup(intInput);
                    } else {
                        System.out.println("Illegal input.");
                    }

                } while (!isInputCorrect);

                try {
                    client.updateStudent(student);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Student not found.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void studentCreationDialog(){
        Scanner sc = new Scanner(System.in);
        System.out.println("New student creation.");
        Student student;

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter last name:");
        String lastName = sc.nextLine();

        boolean isInputCorrect;

        do {
            System.out.println("Enter group No:");
            String userInput = sc.nextLine();

            isInputCorrect = InputChecker.checkNumInput(userInput);
            if (isInputCorrect) {
                int group = Integer.parseInt(userInput);
                student = new Student(name, lastName, group);
                try {
                    client.addStudent(student);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Illegal input.");
            }
        } while (!isInputCorrect);

    }

}
