import java.util.*;

public class ll1 {

    // Define the grammar rules for the language
    static Map<String, List<String>> grammar = new HashMap<>();
    static Map<String, Set<String>> first = new HashMap<>();
    static Map<String, Set<String>> follow = new HashMap<>();
    static Map<String, Map<String, String>> parseTable = new HashMap<>();

    // Initialize the grammar
    static void initGrammar() {
        grammar.put("S", Arrays.asList("AB"));
        grammar.put("A", Arrays.asList("a", "ε"));
        grammar.put("B", Arrays.asList("b"));
    }

    // Compute the FIRST set for a symbol
    static Set<String> computeFirst(String symbol) {
        Set<String> result = new HashSet<>();
        
        // If symbol is a terminal, add it to the FIRST set
        if (!grammar.containsKey(symbol)) {
            result.add(symbol);
            return result;
        }

        // If it's a non-terminal, compute the FIRST set recursively
        for (String production : grammar.get(symbol)) {
            for (int i = 0; i < production.length(); i++) {
                String currentSymbol = String.valueOf(production.charAt(i));

                // If it's a terminal, add it to the FIRST set
                if (!grammar.containsKey(currentSymbol)) {
                    result.add(currentSymbol);
                    break;
                }

                // If it's a non-terminal, compute its FIRST set recursively
                Set<String> firstOfCurrent = computeFirst(currentSymbol);
                result.addAll(firstOfCurrent);

                // If it can derive epsilon, continue to the next symbol
                if (firstOfCurrent.contains("ε")) {
                    if (i == production.length() - 1) {
                        result.add("ε");
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // Compute the FOLLOW set for a non-terminal
    static void computeFollow(String nonTerminal) {
        if (follow.containsKey(nonTerminal)) return; // Already computed
        
        Set<String> result = new HashSet<>();
        if (nonTerminal.equals("S")) {
            result.add("$"); // End of input symbol for the start symbol
        }

        // Traverse the grammar and compute FOLLOW sets
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            String left = entry.getKey();
            List<String> productions = entry.getValue();

            for (String production : productions) {
                int index = production.indexOf(nonTerminal);
                if (index != -1) {
                    // If non-terminal is at the end, add FOLLOW of the left non-terminal
                    if (index == production.length() - 1) {
                        Set<String> followOfLeft = follow.get(left);
                        if (followOfLeft != null) {
                            result.addAll(followOfLeft);
                        }
                    } else {
                        // If non-terminal is followed by another symbol, add its FIRST set
                        String nextSymbol = String.valueOf(production.charAt(index + 1));
                        Set<String> firstOfNext = computeFirst(nextSymbol);
                        result.addAll(firstOfNext);
                    }
                }
            }
        }
        follow.put(nonTerminal, result);
    }

    // Build the LL(1) parse table
    static void buildParseTable() {
        // For each non-terminal, construct the parsing rule in the table
        for (String nonTerminal : grammar.keySet()) {
            Map<String, String> row = new HashMap<>();
            List<String> productions = grammar.get(nonTerminal);
            for (String production : productions) {
                Set<String> firstSet = computeFirst(production);
                for (String terminal : firstSet) {
                    row.put(terminal, production);
                }
                if (firstSet.contains("ε")) {
                    Set<String> followSet = follow.get(nonTerminal);
                    for (String terminal : followSet) {
                        row.put(terminal, "ε");
                    }
                }
            }
            parseTable.put(nonTerminal, row);
        }
    }

    // Perform LL(1) parsing of the input string
    static void parse(String input) {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("S");

        int index = 0;
        while (!stack.isEmpty()) {
            String top = stack.peek();
            String lookahead = index < input.length() ? String.valueOf(input.charAt(index)) : "$";

            if (top.equals(lookahead)) {
                // If stack top matches the lookahead token, pop from stack and move ahead in input
                stack.pop();
                index++;
            } else if (grammar.containsKey(top)) {
                // If top is a non-terminal, get the corresponding rule from the parse table
                Map<String, String> row = parseTable.get(top);
                if (row.containsKey(lookahead)) {
                    String production = row.get(lookahead);
                    stack.pop();
                    // Push the production in reverse order (as it's a stack)
                    for (int i = production.length() - 1; i >= 0; i--) {
                        if (production.charAt(i) != 'ε') {
                            stack.push(String.valueOf(production.charAt(i)));
                        }
                    }
                } else {
                    System.out.println("Parsing error at token: " + lookahead);
                    return;
                }
            } else {
                System.out.println("Parsing error at token: " + lookahead);
                return;
            }
        }

        if (index == input.length()) {
            System.out.println("Input string is successfully parsed!");
        } else {
            System.out.println("Parsing failed at position " + index);
        }
    }

    public static void main(String[] args) {
        // Initialize the grammar, FIRST, and FOLLOW sets
        initGrammar();
        for (String nonTerminal : grammar.keySet()) {
            first.put(nonTerminal, computeFirst(nonTerminal));
        }
        for (String nonTerminal : grammar.keySet()) {
            computeFollow(nonTerminal);
        }

        // Print the FIRST and FOLLOW sets
        System.out.println("FIRST sets:");
        for (String nonTerminal : first.keySet()) {
            System.out.println("FIRST(" + nonTerminal + ") = " + first.get(nonTerminal));
        }

        System.out.println("\nFOLLOW sets:");
        for (String nonTerminal : follow.keySet()) {
            System.out.println("FOLLOW(" + nonTerminal + ") = " + follow.get(nonTerminal));
        }

        // Build the parse table
        buildParseTable();

        // Test parsing an input string
        String input = "ab";  // Change this to test other inputs
        System.out.println("\nParsing input string: " + input);
        parse(input);
    }
}
