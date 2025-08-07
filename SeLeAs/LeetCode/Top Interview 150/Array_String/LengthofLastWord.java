package Array_String;

public class LengthofLastWord {
    public class LengthOfLastWord {

  public static int lengthOfLastWord(String s) {
    if (s == null) return 0;

    int count = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        count++;
      } else {
        if (count > 0) return count;
      }
    }

    return count;
  }

}

}
