package stringasarray;

public class Third {

    public static void countDigits(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                counter++;
            }
        }
        System.out.println(counter);
    }

}
