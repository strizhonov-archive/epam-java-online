package decomposition;

public class Main {

    public static void main(String[] args) {
        First.findLeastCommonMultiple(9, 27);
        Second.findGreatestCommonDivisor(6,90, 18, 27);
        Third.printRegularHexagonArea(5);
        Fourth.findMostRemotePoints(new int[][] {
                {0, -2, -10, 4, 1000},
                {0, -3, -15, 6, -99}
        });
        Fifth.findSecondMax(new int[]{1});
        Sixth.checkIfIntegersAreCoprime(3, 7, 10);
        Seventh.findFactorialSumOfOdds();
        Eighth.findSumByTriple(new int[]{1, 5, 87, 3, 7, 54, -3, 0, 3}, 0, 5);
        Ninth.findQuadrilateralArea(3, 4, 7, 5);
        Tenth.createArrayFromDigits(164);
        Eleventh.compareNumbersByDigitAmount(5, 3);
        Thirteenth.findTwins(41);
        Fourteenth.findArmstrongTo(400);
        Fifteenth.findAscending(5);
        Sixteenth.findSumByRule(1);
        Seventeenth.countIterations(25);

    }

}
