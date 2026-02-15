// Approach (Simple binary addition)
// T.C : O(m + n)
// S.C : O(1)  (excluding result)

class AddBinary {
    public String addBinary(String a, String b) {

        int m = a.length() - 1;
        int n = b.length() - 1;

        StringBuilder result = new StringBuilder();

        int sum = 0;
        int carry = 0;

        while (m >= 0 || n >= 0) {

            sum = carry;

            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }

            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }

            result.append((sum % 2 == 0) ? '0' : '1');

            carry = (sum > 1) ? 1 : 0; // same as sum / 2
        }

        if (carry == 1) {
            result.append('1');
        }

        return result.reverse().toString();
    }
}
