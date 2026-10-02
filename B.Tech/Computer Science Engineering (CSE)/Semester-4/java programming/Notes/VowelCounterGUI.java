import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VowelCounterGUI extends JFrame {
    private JTextField inputField;
    private JTextField resultField;
    
    public VowelCounterGUI() {
        // Set up the frame
        setTitle("Vowel Counter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel inputLabel = new JLabel("Enter a string:");
        inputField = new JTextField(20);
        
        JLabel resultLabel = new JLabel("Number of vowels:");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        
        JButton countButton = new JButton("Count Vowels");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");
        
        // Add action listeners
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countVowels();
            }
        });
        
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Create panels
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(countButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);
        
        // Add panels to main panel
        mainPanel.add(inputPanel);
        mainPanel.add(resultPanel);
        mainPanel.add(buttonPanel);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Show the frame
        setVisible(true);
    }
    
    // Method to count vowels
    private void countVowels() {
        String input = inputField.getText();
        int count = 0;
        
        if (input != null && !input.isEmpty()) {
            input = input.toLowerCase();
            
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }
        }
        
        resultField.setText(String.valueOf(count));
    }
    
    // Method to reset fields
    private void resetFields() {
        inputField.setText("");
        resultField.setText("");
        inputField.requestFocus();
    }
    
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VowelCounterGUI();
            }
        });
    }
} 