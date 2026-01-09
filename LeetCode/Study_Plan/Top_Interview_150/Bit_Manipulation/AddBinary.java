class AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int i = 0, carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i < alen || i < blen || carry != 0) {
            int x = 0;
            if (i < alen && a.charAt(alen - i - 1) == '1') {
                x = 1;
            }

            int y = 0;
            if (i < blen && b.charAt(blen - i - 1) == '1') {
                y = 1;
            }

            ans.append((x + y + carry) % 2);
            carry = (x + y + carry) / 2;
            i++;
        }

        return ans.reverse().toString();
    }
}
