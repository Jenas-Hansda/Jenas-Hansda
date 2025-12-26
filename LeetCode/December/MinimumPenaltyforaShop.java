class MinimumPenaltyforaShop {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        // Initial penalty: shop closed all day → count of 'Y'
        int penalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int minHour = 0;

        // Try closing after each hour
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;   // good to stay open
            } else {
                penalty++;   // bad to stay open
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                minHour = i + 1;
            }
        }

        return minHour;
    }
}
