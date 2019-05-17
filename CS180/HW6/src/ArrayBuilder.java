/**
 * Created by Samrat on 10/10/16.
 */
import java.util.Arrays;
public class ArrayBuilder {

    private char baseLetter;
    private char[][] letterArray;

    private int n;
    private int m;

    public ArrayBuilder(char baseLetter, int n, int m) {
        letterArray = new char[n][m];
        this.baseLetter = baseLetter;
        this.n = n;
        this.m = m;
    }

    public void setLetterArray(char[][] letterArray) {
        this.letterArray = letterArray;
    }
    public void setBaseLetter(char baseLetter) {
        this.baseLetter = baseLetter;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public char getBaseLetter() {
        return baseLetter;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void build() {
        letterArray = new char[this.n][this.m];

        for (int i = 0; i < n; i++) {
            try {
                if (letterArray[i-1][0] == 'Z') {
                    letterArray[i][0] = 'A';
                } else if (letterArray[i-1][0] == 'z') {
                    letterArray[i][0] = 'a';
                } else {
                    letterArray[i][0] = (char) (letterArray[i-1][0] + 1);
                }
            } catch (Exception e) {
                letterArray[i][0] = (char) (baseLetter + i);
            }


            for (int j = 0; j < m; j++) {
                try {
                    if (letterArray[i][j-1] == 'Z') {
                        letterArray[i][j] = 'A';
                    } else if (letterArray[i][j-1] == 'z') {
                        letterArray[i][j] = 'a';
                    } else {
                        letterArray[i][j] = (char) (letterArray[i][j-1] + 1);
                    }
                } catch (Exception e) {
                    letterArray[i][j] = (char) (letterArray[i][0] + j);
                }
            }
        }
    }
    public char[][] getLetterArray() {
//        letterArray = new char[this.n][this.m];
//
//        for (int i = 0; i < n; i++) {
//            try {
//                if (letterArray[i-1][0] == 'Z') {
//                    letterArray[i][0] = 'A';
//                } else if (letterArray[i-1][0] == 'z') {
//                    letterArray[i][0] = 'a';
//                } else {
//                    letterArray[i][0] = (char) (letterArray[i-1][0] + 1);
//                }
//            } catch (Exception e) {
//                letterArray[i][0] = (char) (baseLetter + i);
//            }
//
//
//            for (int j = 0; j < m; j++) {
//                try {
//                    if (letterArray[i][j-1] == 'Z') {
//                        letterArray[i][j] = 'A';
//                    } else if (letterArray[i][j-1] == 'z') {
//                        letterArray[i][j] = 'a';
//                    } else {
//                        letterArray[i][j] = (char) (letterArray[i][j-1] + 1);
//                    }
//                } catch (Exception e) {
//                    letterArray[i][j] = (char) (letterArray[i][0] + j);
//                }
//            }
//        }
        return Arrays.copyOf(letterArray, letterArray.length);

    }



    public void printLetterArray() {
        char[][] array;
        array = getLetterArray();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + "     ");
            }
            System.out.println('\n');
        }

    }

    public static void main(String[] args) {
        ArrayBuilder a = new ArrayBuilder('A', 3,5);
        a.printLetterArray();

    }
}
