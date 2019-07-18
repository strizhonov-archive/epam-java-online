package stringasarray;

public class Fourth {

    public static void countNumbers(String s) {

        int counter = 0;
        boolean isDigitBelongsToTheSameNumber = false;

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                if (!isDigitBelongsToTheSameNumber) {
                    counter++;
                    isDigitBelongsToTheSameNumber = true;
                }
            } else {
                isDigitBelongsToTheSameNumber = false;
            }
        }

        System.out.println(counter);
    }

}
