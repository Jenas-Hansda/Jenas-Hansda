class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // Using a set to avoid duplicates
        HashSet<Long> set = new HashSet<>();

        // Edge cases:
        set.add((long)Math.pow(10, len - 1) - 1); // 999...9
        set.add((long)Math.pow(10, len) + 1);     // 100...001

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long p : new long[]{prefix - 1, prefix, prefix + 1}) {
            StringBuilder sb = new StringBuilder();
            sb.append(p);
            String s = sb.toString();

            String pal;
            if (len % 2 == 0)
                pal = s + new StringBuilder(s).reverse().toString();
            else
                pal = s + new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();

            try {
                long val = Long.parseLong(pal);
                set.add(val);
            } catch (Exception ignored) {}
        }

        long best = -1;
        long diff = Long.MAX_VALUE;

        for (long cand : set) {
            if (cand == num) continue;

            long d = Math.abs(cand - num);
            if (d < diff || (d == diff && cand < best)) {
                diff = d;
                best = cand;
            }
        }
        return String.valueOf(best);
    }
}
