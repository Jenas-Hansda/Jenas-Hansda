

public class GrammarParser {
    
    private static String input;     // The input string to be parsed
    private static int currentPos = 0; // Current position in the string

    // Method to check if the current character matches the expected token
    private static char lookahead() {
        if (currentPos < input.length()) {
            return input.charAt(currentPos);
        }
        return '\0'; // EOF (End of File) character
    }

    // Method to consume a character (move to the next character)
    private static void consume() {
        currentPos++;
    }

    // Factor -> ( Expr ) | num
    private static boolean factor() {
        char currentChar = lookahead();
        if (currentChar == '(') {  // '(' Expr ')'
            consume();  // consume '('
            if (!expr()) {
                return false;  // Invalid expression
            }
            if (lookahead() == ')') {
                consume();  // consume ')'
                return true;
            }
            return false;
        } else if (Character.isDigit(currentChar)) {  // num
            consume();  // consume number
            return true;
        }
        return false; // Invalid factor
    }

    // Term -> Factor | Term * Factor | Term / Factor
    private static boolean term() {
        if (!factor()) {
            return false;  // If the first factor is invalid
        }

        while (true) {
            char currentChar = lookahead();
            if (currentChar == '*' || currentChar == '/') {  // '*' or '/'
                consume();  // consume operator
                if (!factor()) {
                    return false;  // Invalid factor after operator
                }
            } else {
                break;  // No more multiplication or division
            }
        }
        return true;
    }

    // Expr -> Term | Expr + Term | Expr - Term
    private static boolean expr() {
        if (!term()) {
            return false;  // If the first term is invalid
        }

        while (true) {
            char currentChar = lookahead();
            if (currentChar == '+' || currentChar == '-') {  // '+' or '-'
                consume();  // consume operator
                if (!term()) {
                    return false;  // Invalid term after operator
                }
            } else {
                break;  // No more addition or subtraction
            }
        }
        return true;
    }

    // Main method to check if the string belongs to the grammar
    public static boolean parse(String inputString) {
        input = inputString.replaceAll("\\s", ""); // Remove any whitespace
        currentPos = 0;  // Reset position
        return expr() && currentPos == input.length();  // Valid if entire string is parsed
    }

    // Test method
    public static void main(String[] args) {
        String inputString = "3+(2*5)-8";  // Change this input to test other strings
        if (parse(inputString)) {
            System.out.println("The string belongs to the grammar.");
        } else {
            System.out.println("The string does NOT belong to the grammar.");
        }
    }
}
