import java.util.*;

class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] roomsUsedCount = new int[n];

        // Min-heap for used rooms: {endTime, roomNumber}
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] 
                    ? Long.compare(a[1], b[1]) 
                    : Long.compare(a[0], b[0])
        );

        // Min-heap for unused rooms (smallest room index first)
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        for (int[] meet : meetings) {
            int start = meet[0];
            int end   = meet[1];

            // Free rooms that are done before current meeting starts
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                unusedRooms.offer((int) usedRooms.poll()[1]);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                roomsUsedCount[room]++;
            } else {
                // Delay meeting in earliest finishing room
                long[] earliest = usedRooms.poll();
                long newEndTime = earliest[0] + (end - start);
                usedRooms.offer(new long[]{newEndTime, earliest[1]});
                roomsUsedCount[(int) earliest[1]]++;
            }
        }

        // Find room with maximum usage
        int resultRoom = 0;
        for (int i = 1; i < n; i++) {
            if (roomsUsedCount[i] > roomsUsedCount[resultRoom]) {
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
