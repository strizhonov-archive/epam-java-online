package simpleclass.sixth;

public class Main {

    public static void main(String[] args) {

        Time time = new Time();
        System.out.println(time);

        time.setHours(25);
        System.out.println(time);

        time.setHours(13);
        System.out.println(time);

        time.setMinutes(-12);
        System.out.println(time);
        time.setMinutes(34);
        System.out.println(time);

        time.setSeconds(77);
        System.out.println(time);

        time.setSeconds(11);
        System.out.println(time);

        time.addSeconds(62);
        System.out.println(time);

        time.addMinutes(180);
        System.out.println(time);

        time.addHours(22);
        System.out.println(time);
    }

}
