class FactorialTrailingZeroes {
public:
    int trailingZeroes(int n) {
        int trailingZeroes = 0;
        while (n > 0) {
            n /= 5;
            trailingZeroes += n;
        }
        return trailingZeroes;
    }
};
