public class Matrix {
    public boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length == matrix[j].length)
                    continue;
                else
                    return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[j][i])
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
    public boolean isDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length == matrix.length)
                    continue;
                else
                    return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != i && matrix[i][j] != 0)
                    return false;
                else
                    continue;
            }
        }
        return true;
    }

    public boolean isIdentity(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix.length == matrix[j].length)
                    continue;
                else
                    return false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != i && matrix[i][j] != 0 || matrix[i][i] != 1)
                    return false;
                else
                    continue;
            }
        }
        return true;
    }

    public boolean isUpperTriangular(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length == matrix[j].length)
                    continue;
                else
                    return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > j && matrix[i][j] != 0)
                    return false;
                else
                    continue;
            }
        }
        return true;
    }
    public boolean isTridiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i].length == matrix[j].length)
                    continue;
                else
                    return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != i && j!= i+1 && j!=i-1 && matrix[i][j] != 0)
                    return false;
                else
                    continue;
            }
        }
        return true;


    }
    public static void main(String[] args) {

       int [][] matrix = new int[][]{{5,0,0}, {0,9,0}, {0,0,2},};
       Matrix mat = new Matrix();

        System.out.println(mat.isSymmetric(matrix));
        System.out.println(mat.isDiagonal(matrix));
        System.out.println(mat.isIdentity(matrix));
        System.out.println(mat.isUpperTriangular(matrix));
        System.out.println(mat.isTridiagonal(matrix));

    }


}
