import java.util.HashMap;
import java.util.Map;
class Roman_Numeral {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);    // I means 1
        romanMap.put('V', 5);    // V means 5
        romanMap.put('X', 10);   // X means 10
        romanMap.put('L', 50);   // L means 50
        romanMap.put('C', 100);  // C means 100
        romanMap.put('D', 500);  // D means 500
        romanMap.put('M', 1000); // M means 1000

        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue < prevValue) {
                result = result - currentValue;
            } else {
                result = result + currentValue;
            }
            prevValue = currentValue;
        }
        return result;
    }
    public static void main(String[] args) {
        Roman_Numeral converter = new Roman_Numeral();
        String romanNumeral = "XIV";
        int integerValue = converter.romanToInt(romanNumeral);
        System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);
    }
}
