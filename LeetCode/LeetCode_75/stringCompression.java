class stringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;  // Initialize idx to 0

        for (int i = 0; i < n;) {
            char ch = chars[i];
            int count = 0;

            // Count the number of consecutive characters
            while (i < n && chars[i] == ch) {
                count++;
                i++;  // Increment i only inside the while loop
            }

            // Add the character to the result
            chars[idx++] = ch;

            // If count > 1, add the digits of the count to the result
            if (count > 1) {
                String str = Integer.toString(count);  // Convert count to string
                for (char dig : str.toCharArray()) {
                    chars[idx++] = dig;
                }
            }
        }

        // Resize the array by using the new length
        return idx;  // Return the length of the compressed string
    }
}
