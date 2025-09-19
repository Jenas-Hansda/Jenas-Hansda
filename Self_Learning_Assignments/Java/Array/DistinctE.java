package Array;

public class DistinctE{
    public static boolean BurteForce(int nums[] ){
        for(int i=0 ; i<nums.length ; i++){
            for(int j=0 ; j<nums.length ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        BurteForce(nums);
    }
}