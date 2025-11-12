package SurveyProgressIndicator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: add validation unique to each field
public class SurveyForm extends JFrame {
    private JPanel contentPanel;
    private JProgressBar progressBar;
    private JTextField nameField;
    private JTextField birthField;
    private JTextField genderField;
    private JTextField numberField;
    private JTextField emailField;
    private JButton submitButton;
    private JButton resetButton;
    private JLabel gratitudeLabel;

    private final List<JTextField> fields;

    private final Map<JTextField, Boolean> fieldCompletionStatus = new HashMap<>();
    private final int total_forms;

    public SurveyForm() {
        setVisible(true);
        setTitle("Progress Form Indicator - Epilan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        pack();

        fields = Arrays.asList(nameField, birthField, genderField, numberField, emailField);
        total_forms = fields.size();

        for (JTextField field : fields) {
            field.getDocument().addDocumentListener(new DocumentListener() {
                private void updateStatus() {
                    Boolean isCompleted = !field.getText().isEmpty();

                    Boolean status = fieldCompletionStatus.get(field);
                    if (status != isCompleted) {
                        fieldCompletionStatus.put(field, isCompleted);
                        updateProgressBar();
                    }
                }
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateStatus();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateStatus();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {

                }
            });
        }


        reset();
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });
    }

    private void submit() {
        gratitudeLabel.setVisible(true);
    }

    private void reset() {
        updateProgressBar();
        for (JTextField field : fields) {
            field.setText("");
            fieldCompletionStatus.put(field, false);
        }
        submitButton.setEnabled(false);
        gratitudeLabel.setVisible(false);
    }

    private void updateProgressBar() {
        long completed_forms = fieldCompletionStatus.values().stream()
                .filter(isComplete -> isComplete)
                .count();
        double ratio = (double)completed_forms / (double)total_forms;
        int percentage = (int)(ratio * 100);
        progressBar.setValue(percentage);
        submitButton.setEnabled(completed_forms == total_forms);
    }

}
