import java.util.*;

class RandomPickwithBlacklist {
    private Map<Integer, Integer> map;
    private int validNum;
    private Random rand;

    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        rand = new Random();
        
        Set<Integer> blackSet = new HashSet<>();
        for (int b : blacklist) {
            blackSet.add(b);
        }
        
        validNum = N - blackSet.size();
        int last = N - 1;
        
        for (int b : blacklist) {
            if (b < validNum) {
                // find a valid number from the end
                while (blackSet.contains(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }
    
    public int pick() {
        int r = rand.nextInt(validNum); // random number in [0, validNum-1]
        return map.getOrDefault(r, r);   // remap if blacklisted
    }
}
