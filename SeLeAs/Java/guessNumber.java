// Mock of GuessGame class
class GuessGame {
    private int target;

    public GuessGame(int target) {
        this.target = target;
    }

    protected int guess(int num) {
        if (num == target) return 0;
        return num < target ? 1 : -1;
    }
}

// Your actual solution class
public class guessNumber extends GuessGame {
    public guessNumber(int target) {
        super(target);
    }

    public int GuessNumber(int n) { // <-- fixed method name
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        guessNumber game = new guessNumber(42);
        int result = game.GuessNumber(100);
        System.out.println("Guessed number: " + result);
    }
}
