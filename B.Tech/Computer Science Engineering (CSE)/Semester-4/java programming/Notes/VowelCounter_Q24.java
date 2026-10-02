/**
 * VowelCounter_Q24.java
 * 
 * This program creates a GUI application that counts the number of vowels
 * in a string entered in a text field and displays the result in another text field.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VowelCounter_Q24 extends JFrame {
    private JTextField inputField;
    private JTextField resultField;
    private JButton countButton;
    private JButton resetButton;
    private JButton exitButton;
    
    public VowelCounter_Q24() {
        // Set up the frame
        super("Vowel Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel inputLabel = new JLabel("Enter a string:");
        inputField = new JTextField(20);
        
        JLabel resultLabel = new JLabel("Number of vowels:");
        resultField = new JTextField(5);
        resultField.setEditable(false);
        
        countButton = new JButton("Count Vowels");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        
        // Set up the layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));
        
        mainPanel.add(inputLabel);
        mainPanel.add(inputField);
        mainPanel.add(resultLabel);
        mainPanel.add(resultField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(countButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        setContentPane(contentPanel);
        
        // Add action listeners
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                int vowelCount = countVowels_Q24(input);
                resultField.setText(String.valueOf(vowelCount));
            }
        });
        
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultField.setText("");
                inputField.requestFocus();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    /**
     * Counts the number of vowels in a string.
     * 
     * @param str the input string
     * @return the number of vowels in the string
     */
    private int countVowels_Q24(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        // Create and display the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VowelCounter_Q24().setVisible(true);
            }
        });
    }
} 