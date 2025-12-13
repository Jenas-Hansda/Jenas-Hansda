import java.util.*;

class CouponCodeValidator {

    private boolean checkValidCode(String code) {
        if (code == null || code.isEmpty())
            return false;

        for (char ch : code.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> mp = new HashMap<>();
        mp.put("electronics", 0);
        mp.put("grocery", 1);
        mp.put("pharmacy", 2);
        mp.put("restaurant", 3);

        List<int[]> temp = new ArrayList<>(); // {businessPriority, index}

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && mp.containsKey(businessLine[i])
                    && checkValidCode(code[i])) {

                temp.add(new int[]{mp.get(businessLine[i]), i});
            }
        }

        // Sort by business priority, then by coupon code
        Collections.sort(temp, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return code[a[1]].compareTo(code[b[1]]);
        });

        List<String> result = new ArrayList<>();
        for (int[] pair : temp) {
            result.add(code[pair[1]]);
        }

        return result;
    }
}
