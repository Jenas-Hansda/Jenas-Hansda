class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[][] freq = new int[2][26]; 

        for (int i = 0; i < s1.length(); i++) {
            int parity = i % 2;

            freq[parity][s1.charAt(i) - 'a']++;
            freq[parity][s2.charAt(i) - 'a']--;
        }

        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < 26; i++) {
                if (freq[p][i] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}