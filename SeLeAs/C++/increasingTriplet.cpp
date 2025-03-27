#include <string>
#include <vector>

class increasingTriplet {
    public:
        bool IncreasingTriplet(vector<int>& nums) {
            int n = nums.size();
            int k = 3;
            vector<long long> increasing(k, LONG_MAX);
    
            // Increasing Subsequence
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < k; ++j) {
                    if (increasing[j] >= nums[i]) {
                        increasing[j] = nums[i];
                        break;
                    }
                }
                if (increasing[k - 1] != LONG_MAX) {
                    return true;
                }
            }
            return false;
        }
    };
    