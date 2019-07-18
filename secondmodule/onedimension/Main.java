package onedimension;

public class Main {

    public static void main(String[] args) {

        First.summarizeNonReminders(new int[]{1, 2, 5, 10}, 2);
        Second.replaceElements(new double[]{1, 2, 5, 10}, 2);
        Third.countElementsByType(new double[]{1, 2, 5, 10, -4, -7});
        Fourth.switchMinAndMax(new double[]{1, 2, 5, 10, -4, -7});
        Fifth.printElementsByRule(new int[]{1, 0, 5, 10});
        Sixth.summarizeElementsByRule(new double[]{1, 2, 5, 10, -4, -7});
        Seventh.findMax(new double[]{1, 2, 5, 10, -4, -7});
        Eighth.refineArray(new int[]{1, 43, 2, 1, 1, 5, 10});
        Ninth.findTheSmallestMode(new int[]{1, 43, 2, 1, 1, 5, 5, 10, 5, -3, -3, -3});
        Tenth.compressArray(new int[]{1, 43, 2, 1, 1, 5, 5, 10, 5, -3, -3, -3});

    }

}
