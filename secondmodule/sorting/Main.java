package sorting;

public class Main {

    public static void main(String[] args) {
        First.mergeArrays(new int[]{5, 7, 2, 8}, new int[]{51, 72, 12,  3, 9, 4}, 0);
        Second.mergeAscendingArrays(new int[]{0, 5, 23}, new int[]{-34, 5, 34});
        Third.sortWithSelection(new int[]{ 1, 3, 0, 0, 5, -2, 4, 7, 3 });
        Fourth.sortWithSwitching(new int[]{5, 2});
        Fifth.sortWithInserting(new int[]{0, 5, 23, -34, 5, 34});
        Sixth.sortWithShell(new int[]{1, 7, -23, 4, 55, 23, 9, 4});
        Seventh.mergeAscendingArrays(new int[]{0, 5, 23}, new int[]{-34, 5, 34});
        Eighth.convertAndSort(new long[]{1, 5, 6, 8}, new long[]{6, 21, 73, 15});

    }
}
