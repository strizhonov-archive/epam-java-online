package twodimension;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                { 5, 7,  9},
                { 1, 6,  5},
                {-1, 4, 22},
                {20, 4,  2},
                {-1, 6, 22},

        };
        First.findColumnsByRule(matrix);
        Second.findDiagonalElements(matrix);
        Third.findRowAndColumn(1, 1, matrix);
        Fourth.createMatrix(4);
        Fifth.createMatrix(6);
        Sixth.createMatrix(8);
        Seventh.createMatrixFromFunction(6);
        Eighth.switchColumns(matrix);
        Ninth.findMaxColumnSum(matrix);
        Tenth.findPositiveElementsOnDiagonal(matrix);
        Eleventh.countFives();
        Twelfth.sortRowsAscending(matrix);
        Twelfth.sortRowsDescending(matrix);
        Thirteen.sortColumnsAscending(matrix);
        Thirteen.sortColumnsDescending(matrix);
        Fourteenth.createMatrix();
        Fifteenth.replaceElementsWithMax(matrix);
        SixteenthA.createMagicSquare(5);
        SixteenthB.createAllMagicSquares(4);
        SixteenthC.createAllMagicSquares(3);

    }

}
