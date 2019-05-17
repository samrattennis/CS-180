/**
 * Created by sunil on 10/11/16.
 */
public class Student extends Person {
    protected int id;
    protected double gpa;
    protected Professor advisor;

    public Student(String fName, String lName, int id) {
        this(fName, lName, id, 0.0, null);
    }

    public Student(String fName, String lName, int id, double gpa, Professor advisor) {
        super(fName, lName);
        this.id = id;
        this.gpa = gpa;
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gpa=" + gpa +
                ", advisor=" + advisor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Professor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }
}
