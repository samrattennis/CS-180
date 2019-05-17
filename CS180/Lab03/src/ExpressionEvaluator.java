import java.util.*;
public class ExpressionEvaluator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();

        expression.replaceAll(" ", "");
        int length = expression.length();
        int s1 = expression.indexOf('-');
        int s2 = expression.indexOf('+');
        int n1 = Integer.parseInt(expression.substring(s1 + 1, s2));

        int s3 = expression.indexOf('(', 1);
        int s4 = expression.indexOf('*');
        int n2 = Integer.parseInt(expression.substring(s3 + 1, s4));

        int s5 = expression.indexOf('-', 2);
        int n3 = Integer.parseInt(expression.substring(s4 + 1, s5));

        int s6 = expression.indexOf('*', s4 + 1);
        int s7 = expression.indexOf('*', s6 + 1);
        int n4 = Integer.parseInt(expression.substring(s6 + 1, s7));

        int s8 = expression.indexOf(')');
        int n5 = Integer.parseInt(expression.substring(s7 + 1, s8));

        int s9 = expression.indexOf('*', s7 + 1);
        int n6 = Integer.parseInt(expression.substring(s9 + 1, length - 1));

        Double finalExpression = (-n1+Math.sqrt(n2*n3-4*n4*n5))/(2*n6);
        System.out.println(finalExpression);

    }
}
