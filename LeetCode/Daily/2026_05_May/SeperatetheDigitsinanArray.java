class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {
                digits.add(ch - '0');
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[digits.size()];

        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);
        }

        return result;
    }
}