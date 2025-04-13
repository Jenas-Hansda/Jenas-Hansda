import java.util.*;

class FirstFollow {

    // Map to hold the FIRST and FOLLOW sets for each non-terminal
    static Map<String, Set<String>> first = new HashMap<>();
    static Map<String, Set<String>> follow = new HashMap<>();

    // Grammar productions
    static Map<String, List<String>> grammar = new HashMap<>();

    // Initialize the grammar (for simplicity)
    static void initGrammar() {
        grammar.put("S", Arrays.asList("AB"));
        grammar.put("A", Arrays.asList("a", "ε"));
        grammar.put("B", Arrays.asList("b"));
    }

    // Calculate FIRST for a non-terminal or terminal
    static Set<String> calculateFirst(String symbol) {
        Set<String> result = new HashSet<>();

        // If the symbol is a terminal, return it as the FIRST set
        if (!grammar.containsKey(symbol)) {
            result.add(symbol);
            return result;
        }

        // If the symbol is a non-terminal, calculate FIRST recursively
        for (String production : grammar.get(symbol)) {
            for (int i = 0; i < production.length(); i++) {
                String currentSymbol = String.valueOf(production.charAt(i));

                // If it's a terminal, add it to the FIRST set
                if (!grammar.containsKey(currentSymbol)) {
                    result.add(currentSymbol);
                    break;
                }
                // If it's a non-terminal, recursively calculate its FIRST set
                Set<String> firstOfCurrent = calculateFirst(currentSymbol);
                result.addAll(firstOfCurrent);

                // If it can derive epsilon, continue checking the next symbols
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

    // Calculate FOLLOW set for a non-terminal
    static void calculateFollow(String nonTerminal) {
        // If FOLLOW set already calculated, return
        if (follow.containsKey(nonTerminal)) {
            return;
        }

        Set<String> result = new HashSet<>();

        // Initialize FOLLOW set for the start symbol (S)
        if (nonTerminal.equals("S")) {
            result.add("$"); // End of input symbol
        }

        // Check for FOLLOW based on grammar rules
        for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
            String left = entry.getKey();
            List<String> productions = entry.getValue();

            for (String production : productions) {
                int index = production.indexOf(nonTerminal);

                // If the non-terminal is found in the production, calculate FOLLOW
                if (index != -1) {
                    if (index == production.length() - 1) {
                        // If non-terminal is at the end, add FOLLOW of the left-hand side non-terminal
                        Set<String> followOfLeft = follow.get(left);
                        if (followOfLeft != null) {
                            result.addAll(followOfLeft);
                        }
                    } else {
                        // If non-terminal is followed by other symbols, add FIRST of the following symbols
                        String nextSymbol = String.valueOf(production.charAt(index + 1));
                        Set<String> firstOfNext = calculateFirst(nextSymbol);
                        result.addAll(firstOfNext);
                    }
                }
            }
        }

        follow.put(nonTerminal, result);
    }

    // Main method to calculate and display FIRST and FOLLOW sets
    public static void main(String[] args) {
        initGrammar();

        // Calculate FIRST for all non-terminals
        for (String nonTerminal : grammar.keySet()) {
            first.put(nonTerminal, calculateFirst(nonTerminal));
        }

        // Calculate FOLLOW for all non-terminals
        for (String nonTerminal : grammar.keySet()) {
            calculateFollow(nonTerminal);
        }

        // Display FIRST and FOLLOW sets
        System.out.println("FIRST sets:");
        for (String nonTerminal : first.keySet()) {
            System.out.println("FIRST(" + nonTerminal + ") = " + first.get(nonTerminal));
        }

        System.out.println("\nFOLLOW sets:");
        for (String nonTerminal : follow.keySet()) {
            System.out.println("FOLLOW(" + nonTerminal + ") = " + follow.get(nonTerminal));
        }
    }
}
