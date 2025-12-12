import java.util.*;

class CountMentionsPerUser {

    private void applyMessageEvent(List<String> event, int[] mentionCount, int[] offlineTime) {
        int timestamp = Integer.parseInt(event.get(1));
        String idsString = event.get(2);

        String[] ids = idsString.split(" ");

        for (String id : ids) {
            if (id.equals("ALL")) {
                for (int i = 0; i < mentionCount.length; i++) {
                    mentionCount[i]++;
                }
            } 
            else if (id.equals("HERE")) {
                for (int i = 0; i < mentionCount.length; i++) {
                    if (offlineTime[i] == 0 || offlineTime[i] + 60 <= timestamp) {
                        mentionCount[i]++;
                        
                    }
                }
            } 
            else {
                // format idX -> extract X
                int userId = Integer.parseInt(id.substring(2));
                mentionCount[userId]++;
            }
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentionCount = new int[numberOfUsers];
        int[] offlineTime = new int[numberOfUsers];

        // Sort events by timestamp, and if equal: OFFLINE before MESSAGE
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 == t2) {
                // OFFLINE should come before MESSAGE
                boolean aIsOffline = a.get(0).equals("OFFLINE");
                boolean bIsOffline = b.get(0).equals("OFFLINE");

                if (aIsOffline != bIsOffline) {
                    return aIsOffline ? -1 : 1;
                }
                return 0;
            }
            return Integer.compare(t1, t2);
        });

        for (List<String> event : events) {
            String type = event.get(0);

            if (type.equals("MESSAGE")) {
                applyMessageEvent(event, mentionCount, offlineTime);
            } 
            else if (type.equals("OFFLINE")) {
                int timestamp = Integer.parseInt(event.get(1));
                int id = Integer.parseInt(event.get(2));
                offlineTime[id] = timestamp;
            }
        }

        return mentionCount;
    }
}
