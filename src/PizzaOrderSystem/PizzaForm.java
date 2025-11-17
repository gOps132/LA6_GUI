package PizzaOrderSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PizzaForm extends JFrame {
    private JPanel contentPanel;
    private JComboBox pizzaSizeChoice;
    private JComboBox pizzaToppingsChoice;
    private JComboBox extraCheeseChoice;
    private JLabel totalLabel;
    private JButton calculateButton;

    public PizzaForm()  {
        setVisible(true);
        setTitle("Progress Form Indicator - Epilan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        pack();


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 12; // 10 base including the topings
                String size = pizzaSizeChoice.getSelectedItem().toString();
                if (size.equals("Medium")) total += 5;
                else if (size.equals("Large")) total += 10;

                String cheese = extraCheeseChoice.getSelectedItem().toString();
                if (cheese.equals("Yes")) total += 3;

                totalLabel.setText(Integer.toString(total));
            }
        });
    }
}
