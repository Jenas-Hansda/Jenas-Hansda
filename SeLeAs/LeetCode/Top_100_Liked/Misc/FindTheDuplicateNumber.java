import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility class to find a duplicate number in an array using
 * three different approaches.
 */
public class FindTheDuplicateNumber {

  /**
   * Floyd's Tortoise and Hare (Cycle Detection) approach.
   * Assumes exactly one duplicate exists and the input array contains n+1 integers
   * where each integer is in the range [1, n].
   * 
   * @param nums the input array
   * @return the duplicate number
   */
  public int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;

    // Phase 1: Detect intersection point in the cycle
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    // Phase 2: Find the entrance to the cycle
    slow = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  /**
   * Find duplicate by sorting the array.
   * 
   * @param nums the input array
   * @return the duplicate number, or -1 if none found
   */
  public int findDuplicateSorting(int[] nums) {
    Arrays.sort(nums);

    int prev = -1;
    for (int num : nums) {
      if (num == prev)
        return num;
      prev = num;
    }

    return -1;
  }

  /**
   * Find duplicate using a HashSet.
   * 
   * @param nums the input array
   * @return the duplicate number, or -1 if none found
   */
  public int findDuplicateHashSet(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (int num : nums) {
      if (seen.contains(num))
        return num;
      seen.add(num);
    }

    return -1;
  }
}
