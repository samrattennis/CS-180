/**
 * Exam
 * Question 2 -- Complete the method differentiate.
 */
public class Calculus {
    /**
     * This differentiate method takes a String of the format "ax^b" and
     * converts it to the form of "cx^d" where
     *    c = a * b
     *    and
     *    d = b - 1.

     * @param func a String of the format ax^b
     * @return
     *      - If func is null return null.
     *      - If func is empty return an empty string.
     *      - If func is neither null nor empty then it is a string of the form
     *        “ax^b”, where a and b are integers. This method then returns a
      *        string of
     *         the form “cx^d”, where c is the product of a and b, i.e.,
     *         c = a × b,
     *         and
     *         d = b – 1.

     * Examples:
     *    i.    If func is “10x∧0” then a = 10 and b = 0.
     *          So c = a × b = 10 × 0 = 0, and
     *          d = b – 1 = 0 – 1 = –1. Therefore, return “0x∧–1”.
     *
     *    ii.   If func is “–110x∧1” return “–110x∧0”.
     *
     *    iii.  If func is “10x∧4” return “40x∧3”.
     *
     *    iv.   If func is “10x∧–4” return “–40x∧–5”.
     *
     *    v.    If func is “–10x∧4” return “–40x∧3”.
     */
    public String differentiate(String func) {
       if (func == null) {
           return null;
       } else if (func.equals("")) {
           return "";
       }

       while (func.length() >= 4) {
           String a = func.substring(0, func.indexOf('x'));
           String b = func.substring((func.indexOf('^') + 1));
           int a2 = Integer.parseInt(a);
           int b2 = Integer.parseInt(b);
           int c = a2 * b2;
           int d = b2 - 1;
           String func2 = c + "x^" + d;
           return func2;
       }
        return func;

    }
}
