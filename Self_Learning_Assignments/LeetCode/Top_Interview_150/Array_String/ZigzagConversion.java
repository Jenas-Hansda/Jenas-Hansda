package Top_Interview_150.Array_String;

public class ZigzagConversion {
    public class ZigzagConverter {

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder res = new StringBuilder();
        int jumps = (numRows - 1) * 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += jumps) {
                res.append(s.charAt(j));

                int diag = j + jumps - 2 * i;
                if (i > 0 && i < numRows - 1 && diag < s.length()) {
                    res.append(s.charAt(diag));
                }
            }
        }

        return res.toString();
    }
}

}
