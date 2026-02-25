import java.util.*;

class SortIntegersbyTheNumberof1Bits {
    public int[] sortByBits(int[] arr) {
        
        // Convert primitive array to Integer array for custom sorting
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxed, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;   // sort by value if bit count equal
            }
            
            return countA - countB;
        });
        
        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        
        return arr;
    }
}