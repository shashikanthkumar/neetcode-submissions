class Solution {
    public int trap(int[] height) {
       int left=0,leftmax=height[0];
       int right=height.length-1,rightmax=height[height.length-1];
       int water=0;
       for(int i=1;i<height.length;i++){
        if(height[left]<height[right]){
            if(height[left]>=leftmax){
                leftmax=height[left];
            }
            else{
                water+=leftmax-height[left];
            }
            left++;
        }
        else{
            if(height[right]>=rightmax){
                rightmax=height[right];
            }
            else{
                water+=rightmax-height[right];
            }
            right--;
        }
       }
       return water;
    }
}
