package decomposition;

public class Seventeenth {

    public static void countIterations(final int number) {
        int counter = 0;
        int varNum = number;
        while (varNum != 0) {
            int digitSum = getDigitsSum(varNum);
            varNum -= digitSum;
            counter++;
        }
        printResult(counter, number);
    }

    private static int getDigitsSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static void printResult(int counter, int number) {
        System.out.println(counter + " subtraction(s) for " + number + ".");
    }

}
