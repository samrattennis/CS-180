/**
 * Created by Samrat on 10/22/16.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PizzaDelivery extends JFrame implements ActionListener {

    private static final String[] SIZES = {"Small", "Medium", "Large"};
    private static final String[] STYLE = {"Margherita", "Prosciutto", "Diavola", "Verdure", "Calzone"};
    private static final String[] TOPPINGS = {"Garlic", "Jalapenos", "Extra Cheese", "Bacon"};

    private JComboBox styleMenu;
    private JCheckBox[] toppings;
    private boolean top[];
    private JRadioButton[] size;
    private JTextArea output;
    private JScrollPane scrollPane;
    private JButton submit;
    private int selectedSize;

    public PizzaDelivery() {
        this.setTitle("Pizza Shop");
        pizza();
    }

    private void pizza() {
        JPanel opt1, opt2, opt3, opt4;

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        opt2 = new JPanel(new GridLayout(1, 0));

        opt1 = thePanel();
        opt1.setBorder(BorderFactory.createTitledBorder("Options"));

        opt3 = new JPanel(new BorderLayout());
        opt3.add(opt1, BorderLayout.NORTH);

        opt2.add(opt3);
        opt2.add(output());

        opt4 = new JPanel(new FlowLayout());
        submit = button("Submit", opt4);

        c.add(opt2, BorderLayout.NORTH);
        c.add(opt4, BorderLayout.SOUTH);
    }

    private JPanel thePanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        JPanel panel1 = sizes();
        panel.add(panel1);

        JPanel panel3 = style();
        panel.add(panel3);

        JPanel panel2 = topping();
        panel.add(panel2);

        return panel;
    }

    private JPanel sizes() {
        JPanel size1 = new JPanel(new FlowLayout());
        size1.setBorder(BorderFactory.createTitledBorder("Select your pizza size"));
        size = new JRadioButton[SIZES.length];
        ButtonGroup allSizes = new ButtonGroup();
        for (int i = 0; i < SIZES.length; i++) {
            size[i] = new JRadioButton(SIZES[i]);
            allSizes.add(size[i]);
            size1.add(size[i]);
        }
        return size1;
    }

    private JPanel style() {
        JPanel style1 = new JPanel(new FlowLayout());
        style1.setBorder(BorderFactory.createTitledBorder("Select your pizza style"));
        styleMenu = new JComboBox(STYLE);
        styleMenu.addActionListener(this);
        style1.add(styleMenu);
        return style1;
    }

    private JPanel topping() {
        JPanel topping1 = new JPanel();
        topping1.setLayout(new GridLayout(2, 0));
        topping1.setBorder(BorderFactory.createTitledBorder("Choose your toppings"));
        JPanel topping2 = new JPanel(new FlowLayout());
        toppings = new JCheckBox[TOPPINGS.length];
        top = new boolean[TOPPINGS.length];
        for (int i = 0; i < TOPPINGS.length; i++) {
            toppings[i] = new JCheckBox();
            toppings[i].setSelected(top[i]);
            topping2.add(toppings[i]);
            topping2.add(new JLabel(TOPPINGS[i]));
        }
        topping1.add(topping2);
        return topping1;
    }


    public JPanel output() {
        JPanel output1 = new JPanel();
        output1.setLayout(new GridLayout(0,1));
        output1.setBorder(BorderFactory.createTitledBorder("Output"));
        output = new JTextArea(6, 6);
        scrollPane = new JScrollPane(output);
        output1.add(scrollPane);
        return output1;
    }

    private JButton button(String s, Container c) {
        JButton button = new JButton(s);
        c.add(button);
        button.addActionListener(this);
        return button;
    }

    private void action(ActionEvent a) {
        String s;
        JButton actionButton = (JButton) a.getSource();
        if (actionButton == submit) {
            for (int i = 0; i < TOPPINGS.length; i++)
                top[i] = toppings[i].isSelected();
            for (int i = 0; i < SIZES.length; i++)
                if (size[i].isSelected())
                    selectedSize = i;
            s = "";
            for (int i = 0; i < TOPPINGS.length; i++)
                if (top[i])
                    s = s + (TOPPINGS[i] + ", ");
            print("Your custom pizza" + "\n");
            print("Size: " + SIZES[selectedSize] + "\n");
            print("Style: " + STYLE[styleMenu.getSelectedIndex()]);
            if (s.length() > 0) {
                if (s.charAt(s.length() - 2) == ',') {
                    s = s.substring(0, s.length() - 2);
                }
                print("\n" + "Toppings: " + s + "\n");
            } else {
                print("\n" + "No toppings!" + "\n");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o instanceof JButton) {
            action(e);
        }
    }

    public void print(String s) {
        output.append(s);
    }

    public static void main(String[] args) {
        PizzaDelivery pizza = new PizzaDelivery();
        pizza.pack();
        pizza.setVisible(true);
        pizza.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
