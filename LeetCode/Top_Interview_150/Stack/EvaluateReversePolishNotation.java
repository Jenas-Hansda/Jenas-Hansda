class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> (int)((long) a * (long) b));
        operators.put("/", (a, b) -> a / b);

        for (String token : tokens) {
            if (operators.containsKey(token)) {
                int b = st.pop();
                int a = st.pop();
                st.push(operators.get(token).apply(a, b));
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}