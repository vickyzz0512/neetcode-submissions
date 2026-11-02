class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // 先找有序的那一半，只在有序的那一半里判断 target 在不在。 因为只有有序的一段，才能靠头尾两个数确定范围。
        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target){
                return mid;
                // 右边是increase，有序的
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                // 左边是有序的
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
