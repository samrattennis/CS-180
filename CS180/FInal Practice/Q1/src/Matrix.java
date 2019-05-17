/**
 * Exam
 * Question 1 -- Complete the method isDiagonalDominant()
 */
public class Matrix {

    /**
     * The isDiagonalDominant method takes an n x n matrix as input
     * and returns a 1-dimensional boolean array. The boolean array will have a
     * boolean for each row representing whether or not a row in the matrix
     * is diagonally dominant.

     *** How can I tell if a row is diagonally dominant?

     * A row of a square matrix is said to be diagonally dominant if the
     * absolute value of the main diagonal entry for that row is
     * larger than or equal to the sum of the absolute value of all the other
     * (non-diagonal) entries in that same row.
     *
     * Ex. Given the following matrix,
     *  { -10,    4,   -5},
     *  {   3,   -6,    3},
     *  {   4,    2,    3}
     *
     *  Main Diagonal Entries : -10, -6, 3
     *
     * We would evaulate it as
     *  |-10| >= |4| + |-5|   ->  true
     *  |-6|  >= |3| + |3|    ->  true
     *  | 3|  >= |4| + |2|    ->  false
     *
     * And return the boolean array {true, true, false}
     *
     * Assume that the input matrix is neither null nor empty, i.e., it will
     * always contain at least one entry.

     * @param
     *    int[][] mat, a 2-dimensional matrix of type int
     * @return
     *    boolean[]

     * Examples:
     *    i.   {false} if mat is not square
     *
     * 		ii.  {false, true} if mat is {{2, -3},
     *                               {1,  4}}
     *
     * 		iii  {true, true} if mat is {{2, -2},
     *                              {1, -4}}
     *
     * 		iv.  {true, true, true} if mat is {{-17,  8,  8},
     *                                    {  2,  4,  2},
     *                                    {  1, -1,  2}}
     *
     * 		v.  {true} if mat is {{5}}
     *
     */
    public boolean[] isDiagonalDominant(int[][] mat) {
        return null; // delete this line and implement your own solution
    }

}
