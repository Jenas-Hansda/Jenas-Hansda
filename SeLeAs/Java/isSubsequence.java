class isSubsequence {
    public boolean IsSubsequence(String s, String t) {
        int ptr_s = 0, ptr_t = 0;
        while (ptr_s < s.length() && ptr_t < t.length()) {
            if (s.charAt(ptr_s) == t.charAt(ptr_t)) {
                ptr_s++;
            }
            ptr_t++;
        }
        return ptr_s >= s.length();
    }
}
