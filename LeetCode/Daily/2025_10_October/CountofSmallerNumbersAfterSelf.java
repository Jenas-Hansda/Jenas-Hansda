import java.util.*;

class CountofSmallerNumbersAfterSelf {

    private void merge(int[] count, Pair[] arr, int left, int mid, int right) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].value <= arr[j].value) {
                temp[k++] = arr[j++];
            } else {
                count[arr[i].index] += (right - j + 1);
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    private void mergeSort(int[] count, Pair[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(count, arr, left, mid);
            mergeSort(count, arr, mid + 1, right);
            merge(count, arr, left, mid, right);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        int[] count = new int[n];
        mergeSort(count, arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }

    private static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    
}
