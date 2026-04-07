class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] o : obstacles) {
            long key = ((long)o[0] << 32) | (o[1] & 0xffffffffL);
            set.add(key);
        }

        int x = 0, y = 0;
        int maxD = 0;

        int dx = 0, dy = 1;

        for (int cmd : commands) {
            if (cmd == -2) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            } else if (cmd == -1) {
                int temp = dx;
                dx = dy;
                dy = -temp;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    long key = ((long)nx << 32) | (ny & 0xffffffffL);
                    if (set.contains(key)) break;
                    x = nx;
                    y = ny;
                }
            }
            maxD = Math.max(maxD, x * x + y * y);
        }

        return maxD;
    }
}