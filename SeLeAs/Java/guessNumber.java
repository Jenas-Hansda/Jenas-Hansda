public class guessNumber extends GuessGame {
    public int GuessNumber(int n) {
        int low = 1, high = n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;  // Avoid overflow
            int guessed = guess(mid);
            
            if (guessed == 0) {
                return mid;
            } else if (guessed == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}
