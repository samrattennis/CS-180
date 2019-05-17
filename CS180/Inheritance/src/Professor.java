/**
 * A simple class to model
 * Created by sunil on 10/11/16.
 */
public class Professor extends Person implements Instructor {
    protected String email;
    protected String office;
    protected String course;

    public Professor(String fName, String lName, String email, String office, String course) {
        super(fName, lName);
        this.email = email;
        this.office = office;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Professor(String fName, String lName, int heightInInches, int weightInPounds, String email, String office, String course) {

        super(fName, lName, heightInInches, weightInPounds);
        this.email = email;
        this.office = office;
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "email='" + email + '\'' +
                ", office='" + office + '\'' +
                ", course='" + course + '\'' +
                "} " + super.toString();
    }

    public void enterGrades(){
        //some code that enters student grades;
        System.out.println("Professor " + lastName + " has entered grades for " + course);
    }

}
