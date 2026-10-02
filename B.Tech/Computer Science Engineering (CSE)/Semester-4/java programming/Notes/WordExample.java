import java.util.Scanner;

public class WordExample {
    private String strdata;
    
    // Parameterized constructor
    public WordExample(String sentence) {
        // Check if the sentence is terminated by '.', '?' or '!'
        char lastChar = sentence.charAt(sentence.length() - 1);
        if (lastChar == '.' || lastChar == '?' || lastChar == '!') {
            this.strdata = sentence;
        } else {
            throw new IllegalArgumentException("Sentence must be terminated by '.', '?', or '!'");
        }
    }
    
    // Method to count words beginning and ending with a vowel
    public void countWord() {
        // Split the sentence into words
        String[] words = strdata.substring(0, strdata.length() - 1).split("\\s+");
        int count = 0;
        
        System.out.println("\nWords beginning and ending with a vowel:");
        
        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = Character.toLowerCase(word.charAt(0));
                char lastChar = Character.toLowerCase(word.charAt(word.length() - 1));
                
                if (isVowel(firstChar) && isVowel(lastChar)) {
                    System.out.println(word);
                    count++;
                }
            }
        }
        
        System.out.println("Count: " + count);
    }
    
    // Method to place words beginning and ending with vowels at the beginning
    public void placeWord() {
        // Split the sentence into words
        String[] words = strdata.substring(0, strdata.length() - 1).split("\\s+");
        
        StringBuilder vowelWords = new StringBuilder();
        StringBuilder otherWords = new StringBuilder();
        
        for (String word : words) {
            if (word.length() > 0) {
                char firstChar = Character.toLowerCase(word.charAt(0));
                char lastChar = Character.toLowerCase(word.charAt(word.length() - 1));
                
                if (isVowel(firstChar) && isVowel(lastChar)) {
                    vowelWords.append(word).append(" ");
                } else {
                    otherWords.append(word).append(" ");
                }
            }
        }
        
        // Combine both parts and print
        String result = vowelWords.toString() + otherWords.toString().trim() + strdata.charAt(strdata.length() - 1);
        System.out.println("\nRearranged sentence:");
        System.out.println(result);
    }
    
    // Helper method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Word Example Program");
        System.out.println("-------------------");
        
        System.out.println("Enter a sentence (must end with '.', '?', or '!'):");
        String sentence = scanner.nextLine();
        
        try {
            WordExample wordEx = new WordExample(sentence);
            wordEx.countWord();
            wordEx.placeWord();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
} 