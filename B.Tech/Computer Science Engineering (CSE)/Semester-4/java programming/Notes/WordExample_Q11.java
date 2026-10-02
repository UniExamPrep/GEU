/*
11. Define a class Word Example having the following description:
Data members/instance variables:

Private String strdata: to store a sentence.
Parameterized Constructor WordExample(String) : Accept a sentence which
may be terminated by either'.', '? 'or'!' only. The words may be separated by more than one blank space and are in UPPER CASE.

Member Methods:
void countWord(): Find the number of words beginning and ending with a vowel.

void placeWord(): Place the words which begin and end with a vowel at the beginning, followed by the remaining words as they occur in the sentence
*/

import java.util.Scanner;
import java.util.ArrayList;

public class WordExample_Q11 {
    private String strdata;
    
    // Parameterized Constructor
    public WordExample_Q11(String sentence) {
        // Check if the sentence ends with '.', '?' or '!'
        if (sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!")) {
            this.strdata = sentence;
        } else {
            System.out.println("Invalid sentence. Sentence must end with '.', '?' or '!'");
            this.strdata = "";
        }
    }
    
    // Method to count words beginning and ending with a vowel
    public void countWord_Q11() {
        if (strdata.isEmpty()) {
            System.out.println("No valid sentence to process.");
            return;
        }
        
        // Remove the terminating character
        String sentence = strdata.substring(0, strdata.length() - 1);
        
        // Split the sentence into words
        String[] words = sentence.trim().split("\\s+");
        
        int count = 0;
        
        // Check each word
        for (String word : words) {
            if (isVowel_Q11(word.charAt(0)) && isVowel_Q11(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        
        System.out.println("Number of words beginning and ending with a vowel: " + count);
    }
    
    // Method to place words beginning and ending with a vowel at the beginning
    public void placeWord_Q11() {
        if (strdata.isEmpty()) {
            System.out.println("No valid sentence to process.");
            return;
        }
        
        // Remove the terminating character
        String sentence = strdata.substring(0, strdata.length() - 1);
        
        // Split the sentence into words
        String[] words = sentence.trim().split("\\s+");
        
        ArrayList<String> vowelWords = new ArrayList<>();
        ArrayList<String> otherWords = new ArrayList<>();
        
        // Categorize words
        for (String word : words) {
            if (isVowel_Q11(word.charAt(0)) && isVowel_Q11(word.charAt(word.length() - 1))) {
                vowelWords.add(word);
            } else {
                otherWords.add(word);
            }
        }
        
        // Combine both lists
        vowelWords.addAll(otherWords);
        
        // Build the new sentence
        StringBuilder result = new StringBuilder();
        for (String word : vowelWords) {
            result.append(word).append(" ");
        }
        
        // Add the terminating character
        result.append(strdata.charAt(strdata.length() - 1));
        
        System.out.println("Rearranged sentence: " + result.toString());
    }
    
    // Helper method to check if a character is a vowel
    private boolean isVowel_Q11(char ch) {
        ch = Character.toUpperCase(ch);
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a sentence (ending with '.', '?' or '!'):");
        String sentence = scanner.nextLine();
        
        WordExample_Q11 wordEx = new WordExample_Q11(sentence);
        
        wordEx.countWord_Q11();
        wordEx.placeWord_Q11();
        
        scanner.close();
    }
} 