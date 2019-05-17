/**
 * Sample program to show the use of an interface (Instructor) to ensure certain functionality that
 * cannot be captured using the inheritance hierarchy: A Professor is a Person; A TeachingAssistant is a
 * Student; A Student is a Person. Professors and TAs can enterGrades, but not other Students, or all Persons.
 * It is not possible to cleanly add the enterGrades method as part of these three clases to ensure the above
 * requirement.
 * Using an Interface, Instructor, we are able to achieve this by having only the Professor and TeachingAssistant
 * classes implement this interface.
 * In this way, the compiler can check that the enterGrades method is called only on those objects which have the
 * enterGrades method defined, and only those objects that need to have this method define this method.
 *
 * Created by sunil on 10/16/16.
 */
public class InterfaceExample {
    public static void main(String[] args) {
        Professor prof;
        TeachingAssistant ta;
        Student[] students = new Student[2];

        prof = new Professor("Sunil", "Prabhakar", "sunil@purdue.edu", "LWSN3144F", "CS18000");
        ta = new TeachingAssistant("Jane", "Java", 7, 4.00, prof, "Gold", "CS18000", "dk@p.e", "LWSN");
        students[0] = new Student("Alice", "Java", 7343, 4.00, null);
        students[1] = new Student("Jason", "Smith", 23423, 4.00, null);

        handleSession(ta, "Lab");
        handleSession(prof, "Lecture");
        // handleSession(students[0], "Lab"); //not allowed by the compiler.

    }

    private static void handleSession(Instructor instructor, String session){
        //do other stuff for session
        instructor.enterGrades();
    }
}
