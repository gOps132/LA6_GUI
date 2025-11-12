package CharacterCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCounterForm extends JFrame {
    private JPanel contentPanel;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;
    private JButton resetButton;

    private Integer count;
    private String characterInput;

    public CharacterCounterForm() {
        setVisible(true);
        setTitle("Character Counter - Epilan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        pack();

        messageTextArea.setLineWrap(true);

        reset();

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count();
                updateCountLabel();
            }
        });
    }

    private void reset() {
        resetCount();
        messageTextArea.setText("");
        characterTextField.setText("");
        countLabel.setText("0");
    }

    private void count() {
        String messageInput = messageTextArea.getText();
        String input = characterTextField.getText();

        int ctr = 0;
        int last_index = 0;
        while (last_index != -1) {
            last_index = messageInput.indexOf(input, last_index);
            if (last_index != -1) {
                ctr++;
                last_index += input.length();
            }
        }

        this.count = ctr;
    }


    private void updateCountLabel() {
        countLabel.setText(this.count.toString());
    }

    private void resetCount() {
        this.count = 0;
    }
}
