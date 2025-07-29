package Array_String;


class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Pointer to end of valid nums1
        int j = n - 1;         // Pointer to end of nums2
        int k = m + n - 1;     // Pointer to end of merged nums1

        // Merge from the back
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }

        // If nums2 has leftover elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // No need to copy remaining nums1 elements; they're already in place
    }
}
