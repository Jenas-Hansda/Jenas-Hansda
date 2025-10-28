import java.util.*;

class ReconstructItinerary {
    // adjacency list: each airport maps to a min-heap of destinations
    private Map<String, PriorityQueue<String>> adj = new HashMap<>();
    private LinkedList<String> result = new LinkedList<>(); // use LinkedList for efficient addFirst

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // Start DFS from "JFK"
        dfs("JFK");

        return result; // already in correct order
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = adj.get(airport);

        // Visit all outgoing edges in lexicographical order
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll(); // remove smallest destination
            dfs(next);
        }

        // add to result after visiting all destinations (postorder)
        result.addFirst(airport);
    }
}
