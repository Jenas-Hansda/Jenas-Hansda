package Array_String;
class MajorityElement {
    public int majorityElement(int[] nums) {
        Integer element = null;
        int counts = 0;

        for (int num : nums) {
            if (counts == 0) {
                element = num;
            }
            counts += (num == element) ? 1 : -1;
        }

        return element;
    }
}