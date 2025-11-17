package CharacterRemover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterRemoverForm extends JFrame{
    private JPanel contentPanel;
    private JCheckBox vowelCheckbox;
    private JCheckBox consonantCheckbox;
    private JCheckBox numberCheckbox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel output;

    CharacterRemoverForm() {
        setVisible(true);
        setTitle("Character Remover - Epilan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        pack();

        restore();

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restore();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vowelCheckbox.isSelected()) {
                    output.setText(output.getText().replaceAll("[AEIOUaeiou]", ""));
                }
                if (consonantCheckbox.isSelected()) {
                    output.setText(output.getText().replaceAll("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwyz]", ""));
                }
                if (numberCheckbox.isSelected()) {
                    output.setText(output.getText().replaceAll("[0-9]", ""));
                }
            }
        });
    }

    private void restore() {
        String default_text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        output.setText(default_text);
    }
}
