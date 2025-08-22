package Top_Interview_150.Hashmap;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    

class Solution {

  boolean isHappy(int n) {
    Set<Integer> usedIntegers = new HashSet<>();

    while (n != 1 && !usedIntegers.contains(n)) {
      usedIntegers.add(n);

      int sum = 0;
      while (n != 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
      }

      n = sum;
    }

    return n == 1;
  }
}

}
