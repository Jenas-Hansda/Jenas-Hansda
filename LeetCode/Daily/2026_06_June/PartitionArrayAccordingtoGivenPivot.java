class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int countLess = 0;
        int countEqual = 0;

        // Count elements less than and equal to pivot
        for (int num : nums) {
            if (num < pivot) {
                countLess++;
            } else if (num == pivot) {
                countEqual++;
            }
        }

        int i = 0;                          // position for < pivot
        int j = countLess;                  // position for = pivot
        int k = countLess + countEqual;     // position for > pivot

        int[] result = new int[n];

        for (int num : nums) {
            if (num < pivot) {
                result[i++] = num;
            } else if (num == pivot) {
                result[j++] = num;
            } else {
                result[k++] = num;
            }
        }

        return result;
    }
}