/**
 * A simple class to model people.
 * Created by sunil on 10/11/16.
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected int heightInInches;
    protected int weightInPounds;

    public Person(String fName, String lName){ this(fName, lName, 0, 0);}

    public Person(String fName, String lName, int heightInInches, int weightInPounds){
        firstName = fName;
        lastName = lName;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public int getWeightInPounds() {
        return weightInPounds;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public void setWeightInPounds(int weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    @Override
    public String toString() {
        return "Person{" +
                 firstName  +
                " " + lastName +
                ": " + heightInInches +
                " inches tall, " + weightInPounds +
                "lbs. }";
    }
}
