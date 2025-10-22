import java.util.Map;

class IntegertoEnglishWords {
    private static final Map<Integer, String> belowTen = Map.of(
        1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "Five",
        6, "Six", 7, "Seven", 8, "Eight", 9, "Nine"
    );

    private static final Map<Integer, String> belowTwenty = Map.of(
        10, "Ten", 11, "Eleven", 12, "Twelve", 13, "Thirteen", 14, "Fourteen",
        15, "Fifteen", 16, "Sixteen", 17, "Seventeen", 18, "Eighteen", 19, "Nineteen"
    );

    private static final Map<Integer, String> belowHundred = Map.of(
        2, "Twenty", 3, "Thirty", 4, "Forty", 5, "Fifty",
        6, "Sixty", 7, "Seventy", 8, "Eighty", 9, "Ninety"
    );

    private String solve(int num) {
        if (num == 0) return "";

        if (num < 10) {
            return belowTen.get(num);
        }

        if (num < 20) {
            return belowTwenty.get(num);
        }

        if (num < 100) {
            String tens = belowHundred.get(num / 10);
            String units = solve(num % 10);
            return units.isEmpty() ? tens : tens + " " + units;
        }

        if (num < 1000) {
            String hundreds = solve(num / 100) + " Hundred";
            String remainder = solve(num % 100);
            return remainder.isEmpty() ? hundreds : hundreds + " " + remainder;
        }

        if (num < 1_000_000) {
            String thousands = solve(num / 1000) + " Thousand";
            String remainder = solve(num % 1000);
            return remainder.isEmpty() ? thousands : thousands + " " + remainder;
        }

        if (num < 1_000_000_000) {
            String millions = solve(num / 1_000_000) + " Million";
            String remainder = solve(num % 1_000_000);
            return remainder.isEmpty() ? millions : millions + " " + remainder;
        }

        String billions = solve(num / 1_000_000_000) + " Billion";
        String remainder = solve(num % 1_000_000_000);
        return remainder.isEmpty() ? billions : billions + " " + remainder;
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return solve(num).trim();
    }
}
