class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        
        int result = 0;
        int prev = 0;
        int curr = 1;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            } else {
                curr++;
            }
        }
        
        return result + Math.min(prev, curr);
    }
}
