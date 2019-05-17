import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test cases for Matrix
 */
public class MatrixTest {
    private static Matrix m;

    @BeforeClass
    public static void setUp() {
        m = new Matrix();
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantNotSquare1() {
        int[][] inputMatrix = {{2, 5},{1, 3},{6, 2}};

        String message = "isDiagonalDominant(): check when matrix is not square";
        boolean[] expectedResult = {false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantNotSquare2() {
        int[][] inputMatrix = {{4, 7, 4}, {0, 7, 2}};

        String message = "isDiagonalDominant(): check when matrix is not square";
        boolean[] expectedResult = {false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantOneEntryNegative() {
        int[][] inputMatrix = {{-5}};

        String message = "isDiagonalDominant(): check when matrix has just one element that is negative";
        boolean[] expectedResult = {true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantOneEntryZero() {
        int[][] inputMatrix = {{0}};

        String message = "isDiagonalDominant(): check when matrix has just one element that is zero";
        boolean[] expectedResult = {true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantOneEntryPositive() {
        int[][] inputMatrix = {{9}};

        String message = "isDiagonalDominant(): check when matrix has just one element that is positive";
        boolean[] expectedResult = {true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo1() {
        int[][] inputMatrix = {{4, 6},{8, 2}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with all positive elements";
        boolean[] expectedResult = {false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo2() {
        int[][] inputMatrix = {{6, 4},{2, 8}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with all positive elements";
        boolean[] expectedResult = {true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo3() {
        int[][] inputMatrix = {{-9, 5},{-3, 2}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with positive and negative elements";
        boolean[] expectedResult = {true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo4() {
        int[][] inputMatrix = {{2, -3},{1, 4}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with positive and negative elements";
        boolean[] expectedResult = {false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo5() {
        int[][] inputMatrix = {{-6, -1},{-12, -11}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with all negative elements";
        boolean[] expectedResult = {true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantTwoByTwo6() {
        int[][] inputMatrix = {{-5, -7},{-3, -5}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 2x2 with all negative elements";
        boolean[] expectedResult = {false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree1() {
        int[][] inputMatrix = {{8, 4, 1}, {-6, 8, -1}, {3, 2, -7}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to true";
        boolean[] expectedResult = {true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree2() {
        int[][] inputMatrix = {{-6, -3, -2}, {-5, -6, -1}, {-5, -2, -8}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to true";
        boolean[] expectedResult = {true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree3() {
        int[][] inputMatrix = {{8, 3, 7}, {9, 12, 6}, {11, 8, 12}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to false";
        boolean[] expectedResult = {false, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree4() {
        int[][] inputMatrix = {{-6, -12, -3}, {-5, -3, -5}, {-5, 3, 4}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to false";
        boolean[] expectedResult = {false, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree5() {
        int[][] inputMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all elements are zero";
        boolean[] expectedResult = {true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree6() {
        int[][] inputMatrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to true";
        boolean[] expectedResult = {true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree7() {
        int[][] inputMatrix = {{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where all rows evaluate to true";
        boolean[] expectedResult = {true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree8() {
        int[][] inputMatrix = {{7, 3, -2}, {-6, 1, 5}, {5, 1, -2}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {true, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree9() {
        int[][] inputMatrix = {{-12, 6, -3}, {-1, 3, -2}, {0, 5, -4}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {true, true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree10() {
        int[][] inputMatrix = {{16, -8, -6}, {7, 5, -4}, {-6, -1, 8}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {true, false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree11() {
        int[][] inputMatrix = {{5, -3, -5}, {-6, 9, -2}, {8, 1, -9}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {false, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree12() {
        int[][] inputMatrix = {{5, 3, 3}, {5, -12, 3}, {3, 2, -4}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {false, true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantThreeByThree13() {
        int[][] inputMatrix = {{-1, 1, 5}, {-4, 5, -3}, {3, 2, 6}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 3x3 where rows have mixed true/false results";
        boolean[] expectedResult = {false, false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantFourByFour() {
        int[][] inputMatrix = {
                {7, -3, 8, 2},
                {1, 7, 3, -2},
                {-5, -2, -3, 1},
                {9, -2, 3, 16}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 4x4 where rows have mixed true/false results";
        boolean[] expectedResult = {false, true, false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantFiveByFive() {
        int[][] inputMatrix = {
                {21, 3, 8, -3, 2},
                {-1, -18, 5, 2, -4},
                {9, -3, -2, 1, 8},
                {9, 3, -2, 17, 1},
                {-3, 2, 13, 4, -21}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 5x5 where rows have mixed true/false results";
        boolean[] expectedResult = {true, true, false, true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix1() {
        int[][] inputMatrix = {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where all rows evaluate to true";
        boolean[] expectedResult = {true, true, true, true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix2() {
        int[][] inputMatrix = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where all elements are zero";
        boolean[] expectedResult = {true, true, true, true, true, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix3() {
        int[][] inputMatrix = {
                {1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1},
                {1, -1, 1, -1, 1, -1}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where all rows evaluate to false";
        boolean[] expectedResult = {false, false, false, false, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix4() {
        int[][] inputMatrix = {
                {-6, -5, -4, -3, -2, -1},
                {-1, -6, -5, -4, -3, -2},
                {-2, -1, -6, -5, -4, -3},
                {-3, -2, -1, -6, -5, -4},
                {-4, -3, -2, -1, -6, -5},
                {-5, -4, -3, -2, -1, -6}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where all rows evaluate to false";
        boolean[] expectedResult = {false, false, false, false, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix5() {
        int[][] inputMatrix = {
                {17, -3, 8, 1, 2, -2},
                {8, 9, -3, -6, -8, 1},
                {9, 8, 26, 1, -1, -2},
                {-6, -2, 1, 15, 3, 2},
                {8, 2, 7, -12, -16, 3},
                {-5, 2, -5, 1, 3, -12}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where rows have mixed true/false results";
        boolean[] expectedResult = {true, false, true, true, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix6() {
        int[][] inputMatrix = {
                {-21, 5, -3, 6, -2, 1},
                {8, -18, 9, 3, -3, 7},
                {9, 3, -27, 6, 3, -2},
                {-1, 3, 6, 3, -2, -3},
                {8, -3, 8, 7, -28, 1},
                {-3, 5, -2, -1, 3, 8}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where rows have mixed true/false results";
        boolean[] expectedResult = {true, false, true, false, true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix7() {
        int[][] inputMatrix = {
                {-7, -3, 2, 5, -3, 1},
                {-3, -17, 6, 3, -3, 1},
                {0, -1, 3, 3, -1, -4},
                {-7, 3, -2, 16, -1, 1},
                {9, -1, -8, -3, 2, -1},
                {3, 2, 8, 1, -19, 36}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where rows have mixed true/false results";
        boolean[] expectedResult = {false, true, false, true, false, true};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix8() {
        int[][] inputMatrix = {
                {-29, 5, -2, 3, 8, 11},
                {9, 36, -11, -8, 3, 2},
                {9, -11, 3, 16, -12, 3},
                {-6, 3, 5, 23, -1, -2},
                {9, 10, 3, -16, 19, -1},
                {8, 3, -6, -2, 1, -1}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where rows have mixed true/false results";
        boolean[] expectedResult = {true, true, false, true, false, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }

    @Test(timeout = 100)
    public void testIsDiagonalDominantSixBySix9() {
        int[][] inputMatrix = {
                {-9, -2, -6, -7, 1, 3},
                {9, -43, 8, -4, 10, 12},
                {-11, -8, -3, -6, -8, -7},
                {9, 8, 3, 6, 2, 0},
                {8, -13, 9, 18, -56, 1},
                {-10, -6, -8, 3, 8, -13}};

        String message = "isDiagonalDominant(): check when matrix has dimensions 6x6 where rows have mixed true/false results";
        boolean[] expectedResult = {false, true, false, false, true, false};
        boolean[] actualResult = m.isDiagonalDominant(inputMatrix);

        assertTrue(message, Arrays.equals(expectedResult, actualResult));
    }
}
