package simpleclass.third;

public class Student {

    private String name;
    private int group;
    private int[] marks = new int[5];

    public Student(String name, int group, int firstMark,
                   int secondMark, int thirdMArk, int fourthMark, int fifthMark) {
        this.name = name;
        this.group = group;
        marks[0] = firstMark;
        marks[1] = secondMark;
        marks[2] = thirdMArk;
        marks[3] = fourthMark;
        marks[4] = fifthMark;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public int[] getMarks() {
            return marks;
        }

}
