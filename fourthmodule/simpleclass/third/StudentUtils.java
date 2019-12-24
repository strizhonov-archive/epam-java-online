package simpleclass.third;

public class StudentUtils {

    public static void main(String[] args) {

        Student[] secondGroup = new Student[10];

        for (int i = 0; i < secondGroup.length; i++) {
            secondGroup[i] = new Student("Student " + (i + 1), 2,
                    i, i, 9, 9, 10);
        }

        printBestStudents(secondGroup);

    }

    private static void printBestStudents(Student[] students) {

        for (Student student : students) {
            boolean isStudentExcellent = true;
            int[] marks = student.getMarks();

            for (int mark : marks) {
                if (mark < 9) {
                    isStudentExcellent = false;
                    break;
                }
            }

            if (isStudentExcellent) {
                System.out.println("Student " + student.getName() + " from "
                        + student.getGroup() + " group is excellent.");
            }
        }
    }

}
