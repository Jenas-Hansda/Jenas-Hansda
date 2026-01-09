class SolFindFirstandLastPositionofElementinSortedArrayution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = firstSearch(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = lastSearch(nums, target, first, nums.length - 1);
        return new int[]{first, last};
    }

    private int firstSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int lastSearch(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}