public class MyUtils {

   public static boolean isNumeric(String str) {
     try {
         int i = Integer.parseInt(str);
       } catch (Exception l) {

         try {
             double j = Double.parseDouble(str);
           } catch (Exception t) {
             return false;
           }
       }
       return true;
    }
    public static String formatStr(String str) {
        //int element = str.length();
        String element1 = str.substring(1);
        String element2 = element1.toLowerCase();
        String element3 = str.substring(0,1);
        String element4 = element3.toUpperCase();
        String string = element4 + element2;
        return string;

   }

    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("E");
        String sc = s.nextLine();
        MyUtils my = new MyUtils();
        System.out.println(my.formatStr(sc));

    }*/
}
