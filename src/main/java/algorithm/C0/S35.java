package algorithm.C0;

public class S35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }

}
