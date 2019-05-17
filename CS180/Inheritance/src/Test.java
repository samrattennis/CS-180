import CS180.*;

/**
 * Created by sunil on 10/11/16.
 */
class Test {
    public static void main(String[] args) {
        Sup sup = new Sup();
        Sub sub = new Sub();

        //Accessing members of the super class
        sup.a =5;
        //sup.b =5;
        //sup.c =5;

        //Accessing members of the sub class
        //inherited members
        sub.a =5;
        //sub.b =5;
        //sub.c =5;
        sub.d =5;
        //sub.e =5;
        //sub.f =5; 
    }
}
