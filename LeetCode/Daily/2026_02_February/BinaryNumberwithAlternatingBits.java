class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int result = n ^ (n >> 1);
        return (result & (result + 1)) == 0;
    }
}
