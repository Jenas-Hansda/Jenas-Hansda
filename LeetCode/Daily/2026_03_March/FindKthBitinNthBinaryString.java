class FindKthBitinNthBinaryString {
    public char findKthBit(int n, int k) {
        
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1;   // 2^n - 1
        int mid = (length / 2) + 1;  // middle position

        if (k < mid) {
            return findKthBit(n - 1, k);
        } 
        else if (k == mid) {
            return '1';
        } 
        else {
            char ch = findKthBit(n - 1, length - k + 1); // reversed index
            return (ch == '0') ? '1' : '0'; // flipped bit
        }
    }
}