class ComplementofBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int bits = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1; // number of bits
        int mask = (1 << bits) - 1; // creates 111...1 mask

        return n ^ mask;
    }
}