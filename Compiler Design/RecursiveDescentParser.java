

public class RecursiveDescentParser {

    private String input; // Input string to parse
    private int index;    // Current index in the input string

    // Constructor to initialize the input string and the starting index
    public RecursiveDescentParser(String input) {
        this.input = input;
        this.index = 0;
    }

    // Function to match the current character in the input string
    private boolean match(char expected) {
        if (index < input.length() && input.charAt(index) == expected) {
            index++;  // Move to the next character
            return true;
        }
        return false;
    }

    // Function to parse the non-terminal 'A'
    public boolean A() {
        // A → a | ε
        if (match('a')) {
            return true; // Matched 'a'
        }
        return true; // ε is valid for A (empty production)
    }

    // Function to parse the non-terminal 'B'
    public boolean B() {
        // B → b
        return match('b'); // Expecting 'b'
    }

    // Function to parse the non-terminal 'S'
    public boolean S() {
        // S → A B
        if (A()) {
            return B(); // After A, expect B
        }
        return false; // If A or B fails, return false
    }

    // Function to start the parsing process
    public boolean parse() {
        boolean result = S();
        // If the entire input string has been consumed, parsing is successful
        return result && index == input.length();
    }

    public static void main(String[] args) {
        // Test with an example input string
        String input = "ab";  // Change this to test other inputs
        RecursiveDescentParser parser = new RecursiveDescentParser(input);

        if (parser.parse()) {
            System.out.println("Input string is successfully parsed.");
        } else {
            System.out.println("Input string is not valid.");
        }
    }
}
