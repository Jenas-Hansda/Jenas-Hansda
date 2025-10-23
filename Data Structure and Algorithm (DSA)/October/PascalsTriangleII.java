class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }
            prev = curr;
        }
        
        return prev;
    }
}