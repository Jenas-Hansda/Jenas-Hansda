public class ProcessStringwithSpecialOperationsI {
    class Solution {
        public String processStr(String s) {
            StringBuilder sb = new StringBuilder();
    
            for (char ch : s.toCharArray()) {
                switch (ch) {
                    case '*':
                        if (sb.length() > 0) {
                            sb.setLength(sb.length() - 1);
                        }
                        break;
    
                    case '#':
                        sb.append(sb.toString());
                        break;
    
                    case '%':
                        sb.reverse();
                        break;
    
                    default:
                        sb.append(ch);
                }
            }
    
            return sb.toString();
        }
    }
}
