
class Solution {

    public boolean checkLCP(String word, int[][] lcp) {
        int n = word.length();

        
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) != word.charAt(n - 1)) {
                if (lcp[i][n - 1] != 0) return false;
            } else {
                if (lcp[i][n - 1] != 1) return false;
            }
        }

        for (int j = 0; j < n; j++) {
            if (word.charAt(n - 1) != word.charAt(j)) {
                if (lcp[n - 1][j] != 0) return false;
            } else {
                if (lcp[n - 1][j] != 1) return false;
            }
        }

        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (word.charAt(i) == word.charAt(j)) {
                    if (lcp[i][j] != 1 + lcp[i + 1][j + 1]) return false;
                } else {
                    if (lcp[i][j] != 0) return false;
                }
            }
        }

        return true;
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        char[] word = new char[n];
        for (int i = 0; i < n; i++) word[i] = '$';

        for (int i = 0; i < n; i++) {

            
            for (int j = 0; j < i; j++) {
                if (lcp[j][i] != 0) {
                    word[i] = word[j];
                    break;
                }
            }

            
            if (word[i] == '$') {
                boolean[] forbidden = new boolean[26];

                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0) {
                        forbidden[word[j] - 'a'] = true;
                    }
                }

                
                boolean assigned = false;
                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        word[i] = (char) (c + 'a');
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) return ""; 
            }
        }

        String result = new String(word);
        return checkLCP(result, lcp) ? result : "";
    }
}