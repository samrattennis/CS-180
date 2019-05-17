/**
 * Created by Samrat on 10/14/16.
 */
import javax.swing.*;
public class FAFSAGUI {
    public static void main(String[] args) {

        int answer = JOptionPane.YES_OPTION;
        while (answer == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Welcome to the FAFSA!", "Welcome", JOptionPane.INFORMATION_MESSAGE);

            int opt1 = JOptionPane.showConfirmDialog(null, "Have you been accepted into a degree or certificate program?",
                    "Program Acceptance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean isAcceptedStudent;
            if (opt1 == JOptionPane.YES_OPTION) {
                isAcceptedStudent = true;
            } else {
                isAcceptedStudent = false;
            }

            int opt2 = JOptionPane.showConfirmDialog(null, "Are you registered for the selective service?",
                    "Selective Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean isSSregistered;
            if (opt2 == JOptionPane.YES_OPTION) {
                isSSregistered = true;
            } else {
                isSSregistered = false;
            }

            int opt3 = JOptionPane.showConfirmDialog(null, "Do you have a social security number?",
                    "Social Security Number", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean hasSSN;
            if (opt3 == JOptionPane.YES_OPTION) {
                hasSSN = true;
            } else {
                hasSSN = false;
            }

            int opt4 = JOptionPane.showConfirmDialog(null, "Do you have valid residency status?",
                    "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean hasValidResidency;
            if (opt4 == JOptionPane.YES_OPTION) {
                hasValidResidency = true;
            } else {
                hasValidResidency = false;
            }

            String age = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);
            int age1 = Integer.parseInt(age);

            while (age1 < 0) {
                JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: Age", JOptionPane.ERROR_MESSAGE);

                age = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane.QUESTION_MESSAGE);
                age1 = Integer.parseInt(age);
            }

            String credit = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?",
                    "Credit Hours", JOptionPane.QUESTION_MESSAGE);
            int credit1 = Integer.parseInt(credit);

            while (!(credit1 >= 1 && credit1 <= 24)) {
                JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, inclusive.",
                        "Error: Credit Hours", JOptionPane.ERROR_MESSAGE);

                credit = JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?",
                        "Credit Hours", JOptionPane.QUESTION_MESSAGE);
                credit1 = Integer.parseInt(credit);
            }

            String myIncome = JOptionPane.showInputDialog(null, "What is your total yearly income?",
                    "Student Income", JOptionPane.QUESTION_MESSAGE);
            double myIncome1 = Double.parseDouble(myIncome);

            while (myIncome1 < 0) {
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.",
                        "Error: Student Income", JOptionPane.ERROR_MESSAGE);

                myIncome = JOptionPane.showInputDialog(null, "What is your total yearly income?",
                        "Student Income", JOptionPane.QUESTION_MESSAGE);
                myIncome1 = Double.parseDouble(myIncome);
            }

            String parentIncome = JOptionPane.showInputDialog(null, "What is your parent's total yearly income?",
                    "Parent Income", JOptionPane.QUESTION_MESSAGE);
            double parentIncome1 = Double.parseDouble(parentIncome);

            while (parentIncome1 < 0) {
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.",
                        "Error: Parent Income", JOptionPane.ERROR_MESSAGE);

                parentIncome = JOptionPane.showInputDialog(null, "What is your parent's total yearly income?",
                        "Parent Income", JOptionPane.QUESTION_MESSAGE);
                parentIncome1 = Double.parseDouble(parentIncome);
            }

            int opt5 = JOptionPane.showConfirmDialog(null, "Are you a dependent?",
                    "Dependency", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean isDependent;
            if (opt5 == JOptionPane.YES_OPTION) {
                isDependent = true;
            } else {
                isDependent = false;
            }

            String[] classStanding = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
            String classStanding1 = (String) JOptionPane.showInputDialog(null, "What is your current class standing?", "Class Standing",
                    JOptionPane.PLAIN_MESSAGE, null, classStanding, classStanding[0]);
            if (classStanding1.equalsIgnoreCase("Freshman") || classStanding1.equalsIgnoreCase("Sophomore") ||
                    classStanding1.equalsIgnoreCase("Junior") || classStanding1.equalsIgnoreCase("Senior")) {
                classStanding1 = "Undergraduate";
            } else {
                classStanding1 = "Graduate";
            }

            FAFSA fafsa = new FAFSA(isAcceptedStudent, isSSregistered, hasSSN, hasValidResidency, isDependent,
                    age1, credit1, myIncome1, parentIncome1, classStanding1);

            JOptionPane.showMessageDialog(null, "Loans: $" + fafsa.calcStaffordLoan() + "\n" +
                            "Grants: $" + fafsa.calcFederalGrant() + "\n" + "WorkStudy: $" + fafsa.calcWorkStudy() +
                            "\n" + "------------" + "\n" + "Total: $" + fafsa.calcFederalAidAmount(),
                    "FAFSA Results", JOptionPane.INFORMATION_MESSAGE);

            answer = JOptionPane.showConfirmDialog(null, "Would you like to complete another application?",
                    "Continue", JOptionPane.YES_NO_OPTION);
        }
    }
}