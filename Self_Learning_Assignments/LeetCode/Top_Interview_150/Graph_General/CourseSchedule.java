class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqs = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            prereqs.get(pair[0]).add(pair[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, prereqs, visiting, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> prereqs,
                             Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(course)) return true;
        if (visited.contains(course)) return false;

        visiting.add(course);
        for (int pre : prereqs.get(course)) {
            if (hasCycle(pre, prereqs, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(course);
        visited.add(course);

        return false;
    }
}