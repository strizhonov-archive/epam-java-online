package controller;

import model.book.Book;
import model.person.Admin;
import model.person.Person;

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
    private static final String USER_DATA_FILE_PATH = "/home/strizhonov/auth_data.txt";
    private static final String CATALOG_FILE_PATH = "/home/strizhonov/catalog.txt";

    public static ArrayList<Person> loadPeople() throws IOException {
        new FileOutputStream(USER_DATA_FILE_PATH, true).close();

        BufferedReader br = new BufferedReader(new FileReader(USER_DATA_FILE_PATH));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }

        String sFile = sb.toString();

        ArrayList<Person> people = new ArrayList<>();
        String[] sPeople = sFile.split("\n\n");

        for (String sPerson : sPeople) {
            String[] attributes = sPerson.split("\n");

            if (attributes.length == 1 && "".equals(attributes[0])) {
                break;
            }

            boolean isAdmin = Boolean.parseBoolean(attributes[0]);
            String login = attributes[1];
            String encryptedPass = attributes[2];
            String password = PasswordEncrypter.decryptPassword(encryptedPass);
            String eMail = attributes[3];
            people.add(Person.PersonFactory.getPerson(isAdmin, login, password, eMail));
        }
        return people;
    }

    public static void writePerson(Person person) throws IOException {
        ArrayList<String> personAttributes = new ArrayList<>();
        personAttributes.add(String.valueOf(person instanceof Admin));
        personAttributes.add(person.getLogin());
        String password = person.getPassword();
        String encryptedPass = PasswordEncrypter.encryptPassword(password);
        personAttributes.add(encryptedPass);
        personAttributes.add(person.getEMailAddress());
        personAttributes.add(DIVIDER);

        new FileOutputStream(USER_DATA_FILE_PATH, true).close();
        Path file = Paths.get(USER_DATA_FILE_PATH);
        Files.write(file, personAttributes, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static ArrayList<Book> loadCatalog() throws IOException {
        new FileOutputStream(CATALOG_FILE_PATH, true).close();

        BufferedReader br = new BufferedReader(new FileReader(CATALOG_FILE_PATH));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }

        String sFile = sb.toString();

        ArrayList<Book> books = new ArrayList<>();
        String[] sBooks = sFile.split("\n\n");

        for (String sBook : sBooks) {
            String[] attributes = sBook.split("\n");

            if (attributes.length == 1 && "".equals(attributes[0])) {
                break;
            }

            String sId = attributes[0];
            long id = Long.parseLong(sId);
            String name = attributes[1];
            String author = attributes[2];

            String type = attributes[3];
            boolean isPaper = "PaperBook".equals(type);

            Book book;
            if (attributes.length > 4) {
                sb = new StringBuilder();

                for (int i = 4; i < attributes.length; i++) {
                    sb.append(attributes[i]);
                    if (i != attributes.length - 1) {
                        sb.append("\n");
                    }
                }

                book = Book.BookFactory.getBook(isPaper, name, author, id, sb.toString());
            } else {
                book = Book.BookFactory.getBook(isPaper, name, author, id);
            }

            books.add(book);
        }

        return books;
    }

    public static void writeBook(Book book) throws IOException {
        ArrayList<String> bookAttributes = new ArrayList<>();
        bookAttributes.add(String.valueOf(book.getId()));
        bookAttributes.add(book.getName());
        bookAttributes.add(book.getAuthor());
        bookAttributes.add(book.getClass().getSimpleName());
        if (book.getDescription() != null) {
            bookAttributes.add(book.getDescription());
        }
        bookAttributes.add(DIVIDER);

        new FileOutputStream(CATALOG_FILE_PATH, true).close();
        Path file = Paths.get(CATALOG_FILE_PATH);
        Files.write(file, bookAttributes, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static void reWriteBooks() throws IOException {
        new FileOutputStream(CATALOG_FILE_PATH, false).close();

        ArrayList<Book> books = Main.bookContainer.getBooks();
        for (Book book : books) {
            writeBook(book);
        }

    }

}
