import java.util.LinkedList;
import java.util.Queue;

public class dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radiant = new LinkedList<>();
        int n = senate.length();

        // Initialize queues with indices of senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'D') {
                dire.add(i);
            } else {
                radiant.add(i);
            }
        }

        // Simulate the rounds
        while (!dire.isEmpty() && !radiant.isEmpty()) {
            int dIndex = dire.poll();
            int rIndex = radiant.poll();

            // The one with the smaller index bans the other and survives
            if (rIndex < dIndex) {
                radiant.add(rIndex + n);
            } else {
                dire.add(dIndex + n);
            }
        }

        return dire.isEmpty() ? "Radiant" : "Dire";
    }

    // Optional: A main method to test the code
    public static void main(String[] args) {
        dota2Senate solution = new dota2Senate();
        String result = solution.predictPartyVictory("RDD");
        System.out.println(result);  // Output should be "Dire"
    }
}
