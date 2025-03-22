class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 + str2 is equal to str2 + str1
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        
        // Find the greatest common divisor of the lengths of the two strings
        int size = gcd(str1.length(), str2.length());
        
        // Return the substring of str1 from 0 to size
        return str1.substring(0, size);
    }
    
    // Helper function to find the GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
