class Solution {
    public int maxArea(int[] heights) {
        int water=0,left=0, right=heights.length-1;
        while(left<right){
            water=Math.max(water,Math.min(heights[left],heights[right])*(right-left));
            if(heights[left]>heights[right])right--;
            else left++;
        }
        return water;
    }
}
