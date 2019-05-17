import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PizzaShop extends JFrame implements ActionListener    {
    public void actionPerformed(ActionEvent ae) {
        Object object = ae.getSource();
        if (object instanceof JButton) {

        }
    }
    public static void main(String[] args) {

        JFrame jf = new JFrame("Empty");
        jf.setSize(800,600);
        jf.setVisible(true);
        jf.setTitle("Pizza Shop");
// J Panel on the left ----------------------------------------------------------------
        JPanel west = new JPanel();
        jf.add(west,BorderLayout.WEST);

        west.setBorder(new TitledBorder("Options"));
        jf.add(west);

        // J Panel on the right ----------------------------------------------------------------

        JPanel east = new JPanel();




        // Submit Option ---------------------------------------------------------------------------

        JButton jbSouth = new JButton("Submit");
        jf.add(jbSouth, BorderLayout.SOUTH);



// JPanel 2 ---------------------------------------------------------------------------------------
        JPanel jp2 = new JPanel();
        jp2.setBorder(new TitledBorder("Select your pizza choice"));

        JRadioButton small = new JRadioButton("Small");
        JRadioButton medium = new JRadioButton("Medium");
        JRadioButton large = new JRadioButton("Large");

        jp2.add(small);
        jp2.add(medium);
        jp2.add(large);
        west.add(jp2);
        // J Panel 3------------------------------------------------------------------------------------
        String[] style = {"Margherita" , "Prosciutto" , "Diavola" , "Verdure" , "Calzone"};
        JPanel jp3 = new JPanel();
        jp3.setBorder(new TitledBorder("Select your pizza style"));
        JComboBox jcb = new JComboBox(style);
        jp3.add(jcb);
        west.add(jp3);
// J Panel 4----------------------------------------------------------------------------------------
        JPanel jp4 = new JPanel();
        JCheckBox garlic = new JCheckBox("Garlic");
        JCheckBox jalapenos = new JCheckBox("Jalapenos");
        JCheckBox extraCheese = new JCheckBox("Extra cheese");
        JCheckBox bacon = new JCheckBox("Bacon");

        jp4.add(garlic);
        jp4.add(jalapenos);
        jp4.add(extraCheese);
        jp4.add(bacon);

        west.add(jp4);

        //alignment

        west.setLayout(new BoxLayout(west,BoxLayout.Y_AXIS));
        jf.add(west,BorderLayout.WEST);


        // Options field--------------------------------------------------------------------------

        JTextArea output2 = new JTextArea();
        east.setBorder(new TitledBorder("Output"));

        east.add(output2);
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        jf.add(east, BorderLayout.EAST);

        jf.add(east);
    }
}