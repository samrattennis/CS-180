/**
 * Created by sunil on 10/11/16.
 */
public class TeachingAssistant extends Student implements Instructor {
    protected String sectionName;
    protected String courseName;
    protected String email;
    protected String office;

    public TeachingAssistant(String fName, String lName, int id, String sectionName, String courseName, String email, String office) {
        super(fName, lName, id);
        this.sectionName = sectionName;
        this.courseName = courseName;
        this.email = email;
        this.office = office;
    }

    public TeachingAssistant(String fName, String lName, int id, double gpa, Professor advisor, String sectionName, String courseName, String email, String office) {
        super(fName, lName, id, gpa, advisor);
        this.sectionName = sectionName;
        this.courseName = courseName;
        this.email = email;
        this.office = office;
    }

    @Override
    public String toString() {
        return "TeachingAssistant{" +
                "sectionName='" + sectionName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", email='" + email + '\'' +
                ", office='" + office + '\'' +
                "} " + super.toString();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public void enterGrades(){
        //some code that enters student grades;
        System.out.println("TA " + lastName + " has entered grades for " + courseName);
    }
}
