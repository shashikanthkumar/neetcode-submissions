class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i-1]==nums[i]-1){
                count++;
                if(count>max)
                max=count;
            }
            else{
                count=1;
                if(count>max)
                max=count;
            }
        }
        if(count>max)
                max=count;
        return max;
    }
}
