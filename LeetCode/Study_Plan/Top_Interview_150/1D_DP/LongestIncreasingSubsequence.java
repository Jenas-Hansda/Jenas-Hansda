class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(lst, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == lst.size()) {
                lst.add(num);
            } else {
                lst.set(idx, num);
            }
        }
        return lst.size();
    }
}