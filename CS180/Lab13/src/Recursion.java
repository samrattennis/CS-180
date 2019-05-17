import java.io.File;

/**
 * Created by Samrat on 11/28/16.
 */
public class Recursion {

    /**
     * Calculates the determinant of the argument matrix recursively.
     *
     * @param matrix The matrix to find the determinant of
     * @return The determinant of the argument matrix
     */
    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return (matrix[0][0]); // Special Case - returning the number that is within the matrix because the matrix has only 1 element and determinant will be that element
        }
        int determinant = 0;
        int len;

        for (int i = 0; i < matrix.length ; i++) { // this loop breaks down the bigger matrix into smaller ones which are later on used to calculate the determinant
            int[][] breakDown = new int[matrix.length - 1][matrix.length - 1];

            for (int j = 1; j < matrix.length ; j++) {

                for (int k = 0; k < matrix.length; k++) {
                    if (k > i) {
                        breakDown[j - 1][k - 1] = matrix[j][k];
                    } else if (k < i) {
                        breakDown[j - 1][k] = matrix[j][k];
                    }
                }
            }

            if (!(i % 2 == 0)) {
                len = -1;
            } else {
                len = 1;
            }

            determinant += len * matrix[0][i] * (determinant(breakDown));
        }

        return determinant;
    }

    /**
     * Counts the total number of files in the given directory recursively.
     *
     * @param f The current file or directory
     * @return The total number of files in f
     */
    public static int filecount(File f) {
        int fileNumber = 0;
        try {
            for (File f2 : f.listFiles()) {
                if (f2.isFile()) {
                    fileNumber++;
                } else if (f2.isDirectory()) {
                    fileNumber += filecount(f2);
                }
            }
        } catch (NullPointerException e) {
        }
        return fileNumber;
    }
}

