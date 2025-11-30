import java.util.*;

class NumberofAtoms {

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());

        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);

            if (c == '(') {
                st.push(new HashMap<>());
                i++;

            } else if (c == ')') {
                Map<String, Integer> currMap = st.pop();
                i++;

                // Read multiplier
                int mult = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mult = mult * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (mult == 0) mult = 1;   // No multiplier → 1

                // Apply multiplier
                for (String atom : currMap.keySet()) {
                    currMap.put(atom, currMap.get(atom) * mult);
                }

                // Add back to previous map
                Map<String, Integer> top = st.peek();
                for (String atom : currMap.keySet()) {
                    top.put(atom, top.getOrDefault(atom, 0) + currMap.get(atom));
                }

            } else {
                // Parse Atom
                StringBuilder atom = new StringBuilder();
                atom.append(c); 
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    atom.append(formula.charAt(i));
                    i++;
                }

                // Parse count
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) count = 1;

                // Add to current map
                st.peek().put(atom.toString(), st.peek().getOrDefault(atom.toString(), 0) + count);
            }
        }

        // Sort result
        Map<String, Integer> sorted = new TreeMap<>(st.peek());
        StringBuilder result = new StringBuilder();

        for (String atom : sorted.keySet()) {
            result.append(atom);
            int count = sorted.get(atom);
            if (count > 1) result.append(count);
        }

        return result.toString();
    }
}
