import java.io.*;

public class lexicalAnalyzer {

    // List of keywords (optional)
    static String[] keywords = {
        "int", "float", "char", "if", "else", "while", "return", "for", "void"
    };

    // Check if it's a keyword
    public static boolean isKeyword(String str) {
        for (String keyword : keywords) {
            if (str.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    // Check if it's a delimiter
    public static boolean isDelimiter(char ch) {
        return ch == ' ' || ch == '\t' || ch == '\n' || ch == ';' || ch == ',' ||
               ch == '(' || ch == ')' || ch == '{' || ch == '}';
    }

    // Check if it's an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '=';
    }

    public static void main(String[] args) {
        PushbackReader reader = null;  // Using PushbackReader to support unread()
        StringBuilder token = new StringBuilder();
        
        try {
            // Read input file
            reader = new PushbackReader(new FileReader("input.c"));
            int ch;
            System.out.println("Lexical Tokens:");

            while ((ch = reader.read()) != -1) {
                char currentChar = (char) ch;

                // Skip whitespaces
                if (Character.isWhitespace(currentChar)) continue;

                // Handle comments
                if (currentChar == '/') {
                    int nextChar = reader.read();
                    if (nextChar == '/') { // Single-line comment
                        while ((ch = reader.read()) != -1 && ch != '\n'); // skip single-line comment
                        continue;
                    } else if (nextChar == '*') { // Multi-line comment
                        while ((ch = reader.read()) != -1) {
                            if (ch == '*' && (nextChar = reader.read()) == '/') {
                                break;
                            }
                        }
                        continue;
                    } else { // Division operator
                        System.out.println("Operator: /");
                        reader.unread(nextChar); // Return the next character to the stream
                        continue;
                    }
                }

                // Handle operators
                if (isOperator(currentChar)) {
                    System.out.println("Operator: " + currentChar);
                    continue;
                }

                // Handle delimiters
                if (isDelimiter(currentChar)) {
                    if (currentChar != ' ' && currentChar != '\t' && currentChar != '\n') {
                        System.out.println("Delimiter: " + currentChar);
                    }
                    continue;
                }

                // Handle identifiers or constants
                if (Character.isAlphabetic(currentChar) || currentChar == '_') {
                    token.setLength(0);  // Reset the token buffer
                    token.append(currentChar);
                    while ((ch = reader.read()) != -1 && (Character.isAlphabetic((char) ch) || Character.isDigit((char) ch) || (char) ch == '_')) {
                        token.append((char) ch);
                    }
                    reader.unread(ch); // Step back one character

                    if (isKeyword(token.toString())) {
                        System.out.println("Keyword: " + token);
                    } else {
                        System.out.println("Identifier: " + token);
                    }
                } else if (Character.isDigit(currentChar)) {
                    token.setLength(0);  // Reset the token buffer
                    token.append(currentChar);
                    while ((ch = reader.read()) != -1 && Character.isDigit((char) ch)) {
                        token.append((char) ch);
                    }
                    reader.unread(ch); // Step back one character
                    System.out.println("Constant: " + token);
                } else {
                    System.out.println("Unknown Token: " + currentChar);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
