package Array_String;

class ReverseWordsinaString {
    public String reverseWords(String s) {
        // Trim the string and split it by one or more spaces using regex
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder for efficient string manipulation
        StringBuilder reversed = new StringBuilder();

        // Traverse the array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}

