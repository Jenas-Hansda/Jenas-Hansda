import java.util.*;

class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int level = 0;

        char[] genes = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String current = queue.poll();
                if (current.equals(end)) return level;

                char[] currArray = current.toCharArray();

                for (int i = 0; i < currArray.length; i++) {
                    char original = currArray[i];

                    for (char gene : genes) {
                        if (gene == original) continue;

                        currArray[i] = gene;
                        String mutated = new String(currArray);

                        if (!visited.contains(mutated) && bankSet.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    currArray[i] = original; // Restore for next mutation
                }
            }

            level++;
        }

        return -1;
    }
}
