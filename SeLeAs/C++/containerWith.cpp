#include <vector>
using namespace std;



class Solution {
    public:
        int maxArea(vector<int>& height) {
            int maxWater = 0;
            int lp = 0, rp = height.size() - 1;
    
            while (lp < rp) {
                int w = rp - lp;
                int ht = min(height[lp], height[rp]);
                int curWater = w * ht;
                maxWater = max(maxWater, curWater);
    
                // Using if-else for clarity
                if (height[lp] < height[rp]) {
                    lp++;
                } else {
                    rp--;
                }
            }
            return maxWater;
        }
    };
    