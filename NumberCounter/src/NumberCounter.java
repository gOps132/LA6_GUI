import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame {
    private JPanel countForms;
    private JLabel countLabel;
    private JButton increaseButton;
    private JButton decreaseButton;

    private Integer number;

    public NumberCounter() {
        setVisible(true);
        setTitle("Number Counter - Epilan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(countForms);
        pack();

        this.number = 0;
        updateCounter();

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                updateCounter();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number--;
                updateCounter();
            }
        });
    }

    private void updateCounter() {
        countLabel.setText(number.toString());
    }
}
