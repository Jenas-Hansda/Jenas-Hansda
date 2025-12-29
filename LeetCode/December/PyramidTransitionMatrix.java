import java.util.*;

class PyramidTransitionMatrix {

    // Memoization table
    private Map<String, Boolean> memo = new HashMap<>();

    private boolean solve(
            String curr,
            Map<String, List<Character>> mp,
            int idx,
            StringBuilder above
    ) {
        // Pyramid completed
        if (curr.length() == 1) {
            return true;
        }

        String key = curr + "_" + idx + "_" + above.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Move to next row
        if (idx == curr.length() - 1) {
            boolean res = solve(above.toString(), mp, 0, new StringBuilder());
            memo.put(key, res);
            return res;
        }

        String pair = curr.substring(idx, idx + 2);
        if (!mp.containsKey(pair)) {
            memo.put(key, false);
            return false;
        }

        // Try all possible top characters
        for (char ch : mp.get(pair)) {
            above.append(ch); // DO

            if (solve(curr, mp, idx + 1, above)) {
                memo.put(key, true);
                return true;
            }

            above.deleteCharAt(above.length() - 1); // UNDO
        }

        memo.put(key, false);
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> mp = new HashMap<>();

        for (String pattern : allowed) {
            String base = pattern.substring(0, 2);
            char top = pattern.charAt(2);

            mp.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }

        return solve(bottom, mp, 0, new StringBuilder());
    }
}
