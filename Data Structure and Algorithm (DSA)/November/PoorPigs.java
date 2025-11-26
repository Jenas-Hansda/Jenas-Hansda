class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
     int T = minutesToTest / minutesToDie + 1; // number of states per pig
        int pigs = 0;

        // Keep increasing pigs until (T^pigs) >= buckets
        while (Math.pow(T, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}