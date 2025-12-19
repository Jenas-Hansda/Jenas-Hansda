import java.util.*;

class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // time -> list of (person1, person2)
        TreeMap<Integer, List<int[]>> timeMeetings = new TreeMap<>();

        for (int[] meeting : meetings) {
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];

            timeMeetings
                .computeIfAbsent(time, k -> new ArrayList<>())
                .add(new int[]{p1, p2});
        }

        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        // Process meetings in increasing time
        for (int time : timeMeetings.keySet()) {

            List<int[]> meets = timeMeetings.get(time);

            Map<Integer, List<Integer>> adj = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> added = new HashSet<>();

            // Build graph for this time slot
            for (int[] meet : meets) {
                int p1 = meet[0];
                int p2 = meet[1];

                adj.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                adj.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);

                if (knowsSecret[p1] && added.add(p1)) {
                    queue.offer(p1);
                }
                if (knowsSecret[p2] && added.add(p2)) {
                    queue.offer(p2);
                }
            }

            // BFS to spread secret within same-time meetings
            while (!queue.isEmpty()) {
                int person = queue.poll();

                for (int next : adj.getOrDefault(person, Collections.emptyList())) {
                    if (!knowsSecret[next]) {
                        knowsSecret[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        // Collect result
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
