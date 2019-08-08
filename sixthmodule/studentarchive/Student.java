package studentarchive;

public class Student {

    private static int COUNTER = 0;
    private int id;
    private String firstName;
    private String lastName;
    private int group;


    public Student(String firstName, String lastName, int group) {
        this.id = COUNTER;
        COUNTER++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student(int id, String firstName, String lastName, int group) {
        this.id = id;
        COUNTER++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                '}';
    }
}
