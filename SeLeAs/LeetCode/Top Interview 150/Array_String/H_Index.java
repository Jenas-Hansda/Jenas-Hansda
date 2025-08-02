import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
    Arrays.sort(citations); // Step 1: Sort citations in ascending order
    int n = citations.length;
    int i;
    for (i = 1; i <= n; ++i)
        if (citations[n - i] < i) break; // Step 2: Check if the condition breaks
    return i - 1; // Step 3: Return result
}

}
