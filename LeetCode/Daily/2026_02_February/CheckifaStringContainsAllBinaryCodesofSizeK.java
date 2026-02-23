import java.util.HashSet;

class CheckifaStringContainsAllBinaryCodesofSizeK {
    public boolean hasAllCodes(String s, int k) {
        // There should be exactly 2^k unique substrings
        HashSet<String> set = new HashSet<>();
        
        int n = s.length();
        int uniqueSub = 1 << k;   // 2^k
        
        for (int i = k; i <= n; i++) {
            String sub = s.substring(i - k, i);
            
            if (!set.contains(sub)) {
                set.add(sub);
                uniqueSub--;
                
                if (uniqueSub == 0)
                    return true;
            }
        }
        
        return false;
    }
}