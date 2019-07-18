package onedimension;

public class First {

    public static void summarizeNonReminders(int[] array, int k) {

        int sum = 0;
        for (int i : array) {
            if (i % k == 0) {
                sum += i;
            }
        }

        System.out.println("The sum is " + sum + ".");
    }

}
