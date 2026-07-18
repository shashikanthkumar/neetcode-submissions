class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int midpoint=left+(right-left)/2;
            int a=nums[midpoint];
            if(target==a){
                return midpoint;
            }
            else if(target<a){
                right=midpoint-1;
            }
            else if(target>a){
                left=midpoint+1;
            }
        }
        return -1;
    }
}
