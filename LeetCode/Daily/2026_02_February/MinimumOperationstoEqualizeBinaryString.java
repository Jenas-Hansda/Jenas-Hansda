import java.util.*;

class MinimumOperationstoEqualizeBinaryString {
    public int minOperations(String s, int k) {
        int n = s.length();

        // Count initial number of zeros
        int startZeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') startZeros++;
        }

        if (startZeros == 0) return 0; // No operations required

        int[] operations = new int[n + 1];
        Arrays.fill(operations, -1); // operations[z] = min operations to reach z zeros

        // Create sets for even and odd counts
        TreeSet<Integer> evenSet = new TreeSet<>();
        TreeSet<Integer> oddSet = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) evenSet.add(i);
            else oddSet.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startZeros);
        operations[startZeros] = 0;

        // Remove startZeros from appropriate set
        if (startZeros % 2 == 0) evenSet.remove(startZeros);
        else oddSet.remove(startZeros);

        while (!queue.isEmpty()) {
            int z = queue.poll();

            // Calculate possible new range of zeros after operation
            int minNewZ = z + k - 2 * Math.min(k, z);
            int maxNewZ = z + k - 2 * Math.max(0, k - n + z);

            // Choose the correct set based on parity
            TreeSet<Integer> currSet = (minNewZ % 2 == 0) ? evenSet : oddSet;

            // Get all values in range [minNewZ, maxNewZ]
            Integer nextZ = currSet.ceiling(minNewZ);
            while (nextZ != null && nextZ <= maxNewZ) {
                operations[nextZ] = operations[z] + 1;

                if (nextZ == 0) return operations[nextZ]; // Found answer

                queue.offer(nextZ);

                currSet.remove(nextZ); // Remove to skip visited
                nextZ = currSet.ceiling(minNewZ);
            }
        }

        return -1; // Not possible
    }
}