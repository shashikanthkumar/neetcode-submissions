class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // edge case
        }
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }
        
        return nums[left]; // left == right, pointing to minimum
    }
}
