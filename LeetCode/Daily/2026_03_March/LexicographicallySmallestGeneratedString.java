class Solution {

    public boolean isSame(String word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word.charAt(i) != str2.charAt(j)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int N = n + m - 1;
        char[] word = new char[N];

        
        for (int i = 0; i < N; i++) {
            word[i] = '$';
        }

        boolean[] canChange = new boolean[N];

        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                int i_ = i;
                for (int j = 0; j < m; j++) {
                    if (word[i_] != '$' && word[i_] != str2.charAt(j)) {
                        return "";
                    }
                    word[i_] = str2.charAt(j);
                    i_++;
                }
            }
        }

        
        for (int i = 0; i < N; i++) {
            if (word[i] == '$') {
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                if (isSame(new String(word), str2, i, m)) {

                    boolean changed = false;

                    for (int k = i + m - 1; k >= i; k--) {
                        if (canChange[k]) {
                            word[k] = 'b';
                            changed = true;
                            break;
                        }
                    }

                    if (!changed) {
                        return "";
                    }
                }
            }
        }

        return new String(word);
    }
}