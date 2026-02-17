import java.util.*;

class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int HH = 0; HH <= 11; HH++) {
            for (int MM = 0; MM <= 59; MM++) {

                if (Integer.bitCount(HH) + Integer.bitCount(MM) == turnedOn) {
                    String hour = String.valueOf(HH);
                    String minute = (MM < 10 ? "0" : "") + MM;

                    result.add(hour + ":" + minute);
                }
            }
        }

        return result;
    }
}
