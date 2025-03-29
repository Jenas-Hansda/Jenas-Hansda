#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int compress(std::vector<char>& chars) {
        int n = chars.size();
        int idx = 0;  // Initialize idx to 0
    
        for (int i = 0; i < n;) {  // Notice that 'i' is only incremented here
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
                std::string str = std::to_string(count);
                for (char dig : str) {  // Remove the semicolon here
                    chars[idx++] = dig;
                }
            }
        }
    
        chars.resize(idx);  // Resize to the new length
        return idx;  // Return the length of the compressed string
    }
};
